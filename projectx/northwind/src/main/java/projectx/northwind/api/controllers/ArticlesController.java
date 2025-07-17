package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateArticleRequestDto;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;
import projectx.northwind.entities.dtos.responses.ArticleWithUserDto;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {

    private final ArticleService articleService;

    @Autowired
    public ArticlesController(ArticleService articleService) {

        this.articleService = articleService;
    }

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    @GetMapping("/getAll")
    public DataResult<List<ArticleResponseDto>> getAll(){

        return this.articleService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize){

        return this.articleService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<ArticleResponseDto>> getAllSortedDesc(){

        return this.articleService.getAllSortedDesc();
    }

    @GetMapping("/getAllAsc")
    public DataResult<List<ArticleResponseDto>> getAllSortedAsc(){

        return this.articleService.getAllSortedAsc();
    }

    @GetMapping("/getByTitle")
    public DataResult<ArticleResponseDto> getByTitle(@RequestParam String title){

        return this.articleService.getByTitle(title);
    }

    @GetMapping("getByTitleAndUser_Id")
    public DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByTitleAndArticleUser_Id(title, user_id);
    }

    @GetMapping("/getByTitleOrUser_Id")
    public DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByTitleOrArticleUser_Id(title, user_id);
    }

    @GetMapping("/getByUserIn")
    public DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(@RequestParam List<Integer> users){

        return this.articleService.getByArticleUser_IdIn(users);
    }

    @GetMapping("/getByTitleContains")
    public DataResult<List<ArticleResponseDto>> getByTitleContains(@RequestParam String title){

        return this.articleService.getByTitleContains(title);
    }

    @GetMapping("/getByTitlesStartsWith")
    public DataResult<List<ArticleResponseDto>> getByTitleStartsWith(@RequestParam String title){

        return this.articleService.getByTitleStartsWith(title);
    }

    @GetMapping("/getByNameAndUser")
    public DataResult<List<ArticleResponseDto>> getByNameAndUser(@RequestParam String title, @RequestParam int user_id){

        return this.articleService.getByNameAndUser(title, user_id);
    }

    @GetMapping("/getArticleWithUser")
    public DataResult<List<ArticleWithUserDto>> getArticleWithUser(){

        return this.articleService.getArticleWithUser();
    }

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateArticleRequestDto newArticleRequest){

        return ResponseEntity.ok(this.articleService.add(newArticleRequest));
    }

}
