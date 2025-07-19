package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.article.TitleAlreadyExistsException;
import projectx.northwind.core.exceptions.types.articleLike.ArticleLikeAlreadyExistsThisUserThisArticleException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.requests.CreateArticleLikeRequestDto;

public interface ArticleLikeService {

    // =================== INTERNAL METHODS ===================

    boolean existsByLikeUserAndLikeArticle(User likeUser, Article likeArticle);

    // =================== REQUEST METHODS ===================

    Result add(CreateArticleLikeRequestDto newArticleLikeRequest) throws UserNotFoundException, ArticleNotFoundException, ArticleLikeAlreadyExistsThisUserThisArticleException;

}
