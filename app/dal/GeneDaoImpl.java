package dal;

import models.Gene;

import java.util.List;

public class GeneDaoImpl implements GeneDao {
    @Override
    public List<Gene> getAll() {
        return Gene.find.all();
    }
}
