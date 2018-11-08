import controllers.GeneController;
import dal.Repository;
import models.GeneVariant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import play.mvc.Http.Status;
import play.mvc.Result;
import play.test.Helpers;
import scala.Option;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestGeneController {
    private GeneController controller;
    private Repository mockRepo;

    @Before
    public void set_up(){
        mockRepo = Mockito.mock(Repository.class);
        controller = new GeneController(mockRepo);
    }

    @Test
    public void return_empty_list_on_empty_gene_prefix(){
        Option<String> prefix = Option.empty();
        Result results = controller.searchGenes(prefix);

        Assert.assertEquals(Status.OK, results.status());
        Assert.assertEquals("[]", Helpers.contentAsString(results));
    }

    @Test
    public void return_a_gene_list_on_a_valid_prefix(){
        Mockito.when(mockRepo.findGeneNamesByPrefix("BRC")).thenReturn(Arrays.asList("BRCA1", "BRCA2"));

        Option<String> geneName = Option.apply("BRC");
        Result results = controller.searchGenes(geneName);

        Assert.assertEquals(Status.OK, results.status());
        Assert.assertEquals("[\"BRCA1\",\"BRCA2\"]", Helpers.contentAsString(results));
    }

    @Test
    public void return_empty_list_on_empty_gene_name(){
        Option<String> geneName = Option.empty();
        Result results = controller.searchVariants(geneName);

        Assert.assertEquals(Status.OK, results.status());
        Assert.assertEquals("[]", Helpers.contentAsString(results));
    }

    @Test
    public void return_gene_variants_on_known_gene(){
        List<GeneVariant> variants = IntStream.range(0, 10)
                .mapToObj(i -> new GeneVariant())
                .collect(Collectors.toList());

        Mockito.when(mockRepo.getVariants("BRCA1")).thenReturn(variants);

        Option<String> geneName = Option.apply("BRCA1");
        Result results = controller.searchVariants(geneName);

        Assert.assertEquals(Status.OK, results.status());
        Assert.assertEquals(variants.size(), countOccurrences(Helpers.contentAsString(results), Pattern.compile("id")));
    }

    private int countOccurrences(String str, Pattern p){
        Matcher m = p.matcher(str);
        int count = 0;
        while(m.find()) count++;
        return count;
    }

}
