package dal;

import models.GeneVariant;

import java.util.List;

public class RepositoryImpl implements Repository {
    @Override
    public List<String> findGeneNamesByPrefix(String prefix) {
        GeneDao dao = new GeneDaoImpl();
        return dao.findGeneNamesByPrefix(prefix);
    }

    @Override
    public List<GeneVariant> getVariants(String geneName) {
        GeneDao dao = new GeneDaoImpl();
        return dao.getVariants(geneName);
    }
}
