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
public class ArticlesController {

    private ArticleService articleService;

    @Autowired
    public ArticlesController(ArticleService articleService) {

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

    @GetMapping("getByTitleAndUser_Id")
    public DataResult<Article> getByTitleAndUser_Id(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByTitleAndUser_Id(title, user_id);
    }

    @GetMapping("/getByTitleOrUser_Id")
    public DataResult<List<Article>> getByTitleOrUser_Id(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByTitleOrUser_Id(title, user_id);
    }

    @GetMapping("/getByUserIn")
    public DataResult<List<Article>> getByUser_IdIn(@RequestParam List<Integer> users){

        return this.articleService.getByUser_IdIn(users);
    }

    @GetMapping("/getByTitleContains")
    public DataResult<List<Article>> getByTitleContains(@RequestParam String title){

        return this.articleService.getByTitleContains(title);
    }

    @GetMapping("/getByTitlesStartsWith")
    public DataResult<List<Article>> getByTitleStartsWith(@RequestParam String title){

        return this.articleService.getByTitleStartsWith(title);
    }

    @GetMapping("/getByNameAndUser")
    public DataResult<List<Article>> getByNameAndUser(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByNameAndUser(title, user_id);
    }

}
