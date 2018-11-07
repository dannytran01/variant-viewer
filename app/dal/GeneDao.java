package dal;

import models.GeneVariant;

import java.util.List;

public interface GeneDao {
    List<String> findGeneNamesByPrefix(String name);
    List<GeneVariant> getVariants(String geneName);
}
