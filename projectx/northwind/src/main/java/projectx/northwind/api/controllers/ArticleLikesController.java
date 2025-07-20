package projectx.northwind.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.ArticleLikeService;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.article.NoArticlesExistException;
import projectx.northwind.core.exceptions.types.articleLike.ArticleLikeAlreadyExistsThisUserThisArticleException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateArticleLikeRequestDto;
import projectx.northwind.entities.dtos.responses.ArticleLikeResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/articleLikes")
public class ArticleLikesController {

    private final ArticleLikeService articleLikeService;

    @Autowired
    public ArticleLikesController(ArticleLikeService articleLikeService) {

        this.articleLikeService = articleLikeService;
    }

    // =================== RESPONSE METHODS ===================

    @GetMapping("/getAll")
    public DataResult<List<ArticleLikeResponseDto>> getAll() throws NoArticlesExistException {

        return this.articleLikeService.getAll();
    }

    // =================== REQUEST METHODS ===================

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CreateArticleLikeRequestDto newArticleLikeRequestDto) throws UserNotFoundException, ArticleNotFoundException, ArticleLikeAlreadyExistsThisUserThisArticleException {

        return ResponseEntity.ok(this.articleLikeService.add(newArticleLikeRequestDto));
    }

}
