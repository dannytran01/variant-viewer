package dal;

import models.GeneVariant;

import java.util.List;

public interface GeneDao {
    List<String> findGeneNamesByPrefix(String prefix);
    List<GeneVariant> getVariants(String geneName);
}
