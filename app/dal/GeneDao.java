package dal;

import models.Gene;
import models.GeneVariant;

import java.util.List;

public interface GeneDao {
    List<Gene> getAll();
    List<String> findGeneNamesByPrefix(String name);
    List<GeneVariant> getVariants(String geneName);
}
