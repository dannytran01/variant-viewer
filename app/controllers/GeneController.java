package controllers;

import models.GeneVariant;
import dal.Repository;
import models.Gene;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;
import util.RestApiUtil;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class GeneController extends Controller {

    private Repository repo;

    @Inject
    public GeneController(Repository repo){
        this.repo = repo;
    }

    public Result searchGenes(Option<String> prefix){
        if(RestApiUtil.isSearchStrEmpty(prefix)){
            return ok(Json.toJson(Collections.emptyList()));
        }
        List<String> genes = repo.findGeneNamesByPrefix(prefix.get());
        return ok(Json.toJson(genes));
    }

    public Result searchVariants(Option<String> geneName){
        if(RestApiUtil.isSearchStrEmpty(geneName)){
            return ok(Json.toJson(Collections.emptyList()));
        }
        List<GeneVariant> variants = repo.getVariants(geneName.get());
        return ok(Json.toJson(variants));
    }

}
