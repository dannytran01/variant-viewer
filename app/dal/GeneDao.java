package dal;

import models.Gene;

import java.util.List;

public interface GeneDao {
    List<Gene> getAll();
}
