package dal;

import models.Gene;
import models.GeneVariant;

import java.util.List;

public class RepositoryImpl implements Repository {
    @Override
    public List<Gene> getGenes() {
        GeneDao dao = new GeneDaoImpl();
        return dao.getAll();
    }

    @Override
    public List<String> findGeneNamesByPrefix(String name) {
        GeneDao dao = new GeneDaoImpl();
        return dao.findGeneNamesByPrefix(name);
    }

    @Override
    public List<GeneVariant> getVariants(String geneName) {
        GeneDao dao = new GeneDaoImpl();
        return dao.getVariants(geneName);
    }
}
