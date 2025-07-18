package projectx.northwind.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.article.NoArticlesExistException;
import projectx.northwind.core.exceptions.types.article.TitleAlreadyExistsException;
import projectx.northwind.core.exceptions.types.common.ArticleAndUserNotFoundException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
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

    @GetMapping("/getAll")
    public DataResult<List<ArticleResponseDto>> getAll() throws NoArticlesExistException {

        return this.articleService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize) throws NoArticlesExistException {

        return this.articleService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<ArticleResponseDto>> getAllSortedDesc() throws NoArticlesExistException {

        return this.articleService.getAllSortedDesc();
    }

    @GetMapping("/getAllAsc")
    public DataResult<List<ArticleResponseDto>> getAllSortedAsc() throws NoArticlesExistException {

        return this.articleService.getAllSortedAsc();
    }

    @GetMapping("/getByTitle")
    public DataResult<ArticleResponseDto> getByTitle(@RequestParam String title) throws ArticleNotFoundException {

        return this.articleService.getByTitle(title);
    }

    @GetMapping("getByTitleAndUser_Id")
    public DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(@RequestParam String title, @RequestParam int user_id) throws ArticleNotFoundException, UserNotFoundException {

        return this.articleService.getByTitleAndArticleUser_Id(title, user_id);
    }

    @GetMapping("/getByTitleOrUser_Id")
    public DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(@RequestParam String title, @RequestParam int user_id) throws ArticleAndUserNotFoundException {

        return this.articleService.getByTitleOrArticleUser_Id(title, user_id);
    }

    @GetMapping("/getByArticleUser_IdIn")
    public DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(@RequestParam List<Integer> users) throws NoUsersExistsException {

        return this.articleService.getByArticleUser_IdIn(users);
    }

    @GetMapping("/getByTitleContains")
    public DataResult<List<ArticleResponseDto>> getByTitleContains(@RequestParam String title) throws EmptyListException {

        return this.articleService.getByTitleContains(title);
    }

    @GetMapping("/getByTitlesStartsWith")
    public DataResult<List<ArticleResponseDto>> getByTitleStartsWith(@RequestParam String title) throws EmptyListException {

        return this.articleService.getByTitleStartsWith(title);
    }

    @GetMapping("/getByNameAndUser")
    public DataResult<List<ArticleResponseDto>> getByNameAndUser(@RequestParam String title, @RequestParam int user_id) throws EmptyListException {

        return this.articleService.getByNameAndUser(title, user_id);
    }

    @GetMapping("/getArticleWithUser")
    public DataResult<List<ArticleWithUserDto>> getArticleWithUser() throws NoUsersExistsException, NoArticlesExistException {

        return this.articleService.getArticleWithUser();
    }

    // =================== REQUEST METHODS ===================

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CreateArticleRequestDto newArticleRequest) throws UserNotFoundException, TitleAlreadyExistsException {

        return ResponseEntity.ok(this.articleService.add(newArticleRequest));
    }

}
