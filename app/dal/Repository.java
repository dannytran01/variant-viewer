package dal;

import com.google.inject.ImplementedBy;
import models.Gene;

import java.util.List;

@ImplementedBy(RepositoryImpl.class)
public interface Repository {
    List<Gene> getGenes();
}
