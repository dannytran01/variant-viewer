package dal;

import com.google.inject.ImplementedBy;
import models.GeneVariant;

import java.util.List;

/**
 * Collections of all available data access methods.
 * Ideally, other DAOs rather than just Gene are collected here.
 */
@ImplementedBy(RepositoryImpl.class)
public interface Repository {
    List<String> findGeneNamesByPrefix(String prefix);
    List<GeneVariant> getVariants(String geneName);
}
