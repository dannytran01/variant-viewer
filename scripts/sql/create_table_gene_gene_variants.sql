CREATE TABLE IF NOT EXISTS gene (
	id UUID,
	name varchar(255) UNIQUE NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS gene_variant (
	id UUID,
	gene_id UUID REFERENCES gene (id),
	nt_change TEXT,
	protein_change TEXT,
	other_mappings TEXT,
	alias TEXT,
	region TEXT,
	reported_classification TEXT,
	last_evaluated DATE,
	last_updated DATE,
	source TEXT,
	url TEXT,
	PRIMARY KEY(id)
);

CREATE INDEX IF NOT EXISTS gene_id_index ON gene_variant (gene_id);
