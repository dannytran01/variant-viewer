package dal;

import com.google.inject.ImplementedBy;
import models.Gene;
import models.GeneVariant;

import java.util.List;

/**
 * Collections of all available data type access.
 * Ideally, other DAOs rather than just Gene are collected here.
 */
@ImplementedBy(RepositoryImpl.class)
public interface Repository {
    List<Gene> getGenes();
    List<String> findGeneNamesByPrefix(String name);
    List<GeneVariant> getVariants(String geneName);
}
