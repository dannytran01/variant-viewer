package controllers;

import dal.Repository;
import models.Gene;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class GeneController extends Controller {

    private Repository repo;

    @Inject
    public GeneController(Repository repo){
        this.repo = repo;
    }

    public Result list() {
        List<Gene> genes = repo.getGenes();
        return ok(Json.toJson(genes));
    }
}
