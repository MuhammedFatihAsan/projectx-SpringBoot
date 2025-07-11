package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {

        this.articleService = articleService;
    }

    @GetMapping("/getall")
    public DataResult<List<Article>> getAll(){

        return this.articleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Article article){

        return this.articleService.add(article);
    }

    @GetMapping("/getByTitle")
    public DataResult<Article> getByTitle(@RequestParam String title){

        return this.articleService.getByTitle(title);
    }

}
