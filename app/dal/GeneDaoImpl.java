package dal;

import models.Gene;
import models.GeneVariant;

import java.util.List;

public class GeneDaoImpl implements GeneDao {
    @Override
    public List<String> findGeneNamesByPrefix(String name) {
        return Gene.find.query()
                .setDistinct(true)
                .select("name")
                .where().istartsWith("name", name)
                .findSingleAttributeList();
    }

    @Override
    public List<GeneVariant> getVariants(String geneName) {
        return GeneVariant.find.query()
                .where().ilike("gene.name", geneName)
                .findList();
    }
}
