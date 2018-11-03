package dal;

import models.Gene;

import java.util.List;

public class RepositoryImpl implements Repository {
    @Override
    public List<Gene> getGenes() {
        GeneDao dao = new GeneDaoImpl();
        return dao.getAll();
    }
}
