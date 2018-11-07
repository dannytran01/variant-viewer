import argparse
import uuid
import os

# Simple script to parse in a variant tsv file and generate SQL inserts in bulk
def main():
    parser = argparse.ArgumentParser(description='Parse parameters')
    parser.add_argument('-f', '--file', required=True, type=argparse.FileType('r'))
    args = parser.parse_args()

    lines = args.file.readlines()
    genes_file = open('gene_sql_data.sql', 'w', encoding='utf8')
    genes_file.write(create_insert_gene())

    variants_file = open('variant_sql_data.sql', 'w', encoding='utf8')
    variants_file.write(create_insert_variant())

    gene_dict = {}
    for line in lines[1:]:  # ignore header
        temp = line.split('\t')
        gene_name = temp[0].strip()

        if gene_name:  # variants may not have a gene
            if gene_name not in gene_dict:
                temp_uuid = uuid.uuid4()
                gene_dict[gene_name] = temp_uuid
            else:
                temp_uuid = gene_dict[gene_name]
        else:
            temp_uuid = ""

        variant_str = write_variant_sql(uuid.uuid4(), temp_uuid, temp[1], temp[2], temp[3], temp[4], temp[6], temp[7],
                                        temp[10], temp[11], temp[9], temp[12])
        variants_file.write(variant_str)

    for name, gene_uuid in gene_dict.items():
        gene_str = write_gene_sql(gene_uuid, name)
        genes_file.write(gene_str)

    file_clean_up(genes_file)
    file_clean_up(variants_file)

    genes_file.close()
    variants_file.close()


# SQL utilities functions

def write_gene_sql(gene_uuid, name):
    return "({}, {}),\n".format(uuid_format(gene_uuid), data_clean_up(name))


def write_variant_sql(id, gene_id, nt_change, protein_change, other_mappings, alias, region, reported_class, last_eval,
                      last_update,
                      source, url):
    return "({}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}),\n".format(uuid_format(id), uuid_format(gene_id),
                                                                        data_clean_up_with_null(nt_change),
                                                                        data_clean_up_with_null(protein_change),
                                                                        data_clean_up_with_null(other_mappings),
                                                                        data_clean_up_with_null(alias),
                                                                        data_clean_up_with_null(region),
                                                                        data_clean_up_with_null(reported_class),
                                                                        data_clean_up_with_null(last_eval),
                                                                        data_clean_up_with_null(last_update),
                                                                        data_clean_up_with_null(source),
                                                                        data_clean_up_with_null(url))


def create_insert_gene():
    return "INSERT INTO gene (id, name) VALUES \n"


def create_insert_variant():
    return "INSERT INTO gene_variant (id, gene_id, nt_change, protein_change, other_mappings, \"alias\", region, reported_classification, last_evaluated, last_updated, \"source\", url) VALUES \n"


def file_clean_up(input):
    input.seek(input.tell() - 3, os.SEEK_SET)
    input.write(";")


def data_clean_up_with_null(input):
    input = input.strip().replace('\'', '\'\'') # to handle ignoring quotes in postgresql and encoding errors
    return "'" + input + "'" if input else 'null'


def data_clean_up(input):
    return "'" + input.strip() + "'"


def uuid_format(input):
    return "'" + str(input) + "'" if input else 'null'


if __name__ == "__main__":
    main()
