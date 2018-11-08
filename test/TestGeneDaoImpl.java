import dal.GeneDao;
import dal.GeneDaoImpl;
import models.GeneVariant;
import org.junit.Assert;
import org.junit.Test;
import play.test.WithApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static play.test.Helpers.*;

public class TestGeneDaoImpl extends WithApplication {

    @Test
    public void should_return_correct_number_of_genes_given_a_valid_prefix(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<String> queriedNames = dao.findGeneNamesByPrefix("BRC");
            List<String> expectedGenes = Arrays.asList("BRCA1", "BRCA2", "BRCC3");

            Assert.assertEquals(expectedGenes, queriedNames);
        });
    }

    @Test
    public void should_return_genes_when_case_is_lower(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<String> queriedNames = dao.findGeneNamesByPrefix("brc");
            List<String> expectedGenes = Arrays.asList("BRCA1", "BRCA2", "BRCC3");

            Assert.assertEquals(expectedGenes, queriedNames);
        });
    }

    @Test
    public void should_return_no_genes_given_an_invalid_prefix(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<String> queriedNames = dao.findGeneNamesByPrefix("BOOGALOO");

            Assert.assertEquals(Collections.emptyList(), queriedNames);
        });
    }

    @Test
    public void should_return_variants_when_a_valid_gene_is_given(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<GeneVariant> variants = dao.getVariants("DDX52");

            Assert.assertEquals(61, variants.size());
        });
    }

    @Test
    public void should_return_variants_when_a_valid_gene_in_lowercase_is_given(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<GeneVariant> variants = dao.getVariants("ddx52");

            Assert.assertEquals(61, variants.size());
        });
    }

    @Test
    public void should_return_no_variants_when_an_invalid_gene_is_given(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            GeneDao dao = new GeneDaoImpl();
            List<GeneVariant> variants = dao.getVariants("BOOGALOO");

            Assert.assertEquals(0, variants.size());
        });
    }
}
