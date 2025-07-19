package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleLikeService;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.articleLike.ArticleLikeAlreadyExistsThisUserThisArticleException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.ArticleLikeDao;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.ArticleLike;
import projectx.northwind.entities.dtos.requests.CreateArticleLikeRequestDto;

@Service
public class ArticleLikeManager implements ArticleLikeService {

    private final ArticleLikeDao articleLikeDao;
    private final UserService userService;
    private final ArticleService articleService;

    @Autowired
    public ArticleLikeManager(ArticleLikeDao articleLikeDao,  UserService userService, ArticleService articleService) {

        this.articleLikeDao = articleLikeDao;
        this.userService = userService;
        this.articleService = articleService;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByLikeUserAndLikeArticle(User likeUser, Article likeArticle) {

        return articleLikeDao.existsByLikeUserAndLikeArticle(likeUser, likeArticle);
    }

    // =================== REQUEST METHODS ===================

    @Override
    public Result add(CreateArticleLikeRequestDto newArticleLikeRequest) throws UserNotFoundException, ArticleNotFoundException, ArticleLikeAlreadyExistsThisUserThisArticleException {

        checkUserExists(newArticleLikeRequest.getUserId());
        checkArticleExists(newArticleLikeRequest.getArticleId());
        checkUserArticleAlreadyExists(newArticleLikeRequest.getUserId(), newArticleLikeRequest.getArticleId());

        ArticleLike articleLike = new ArticleLike();

        articleLike.setLikeUser(this.userService.findById(newArticleLikeRequest.getUserId()));
        articleLike.setLikeArticle(this.articleService.findById(newArticleLikeRequest.getArticleId()));

        this.articleLikeDao.save(articleLike);

        return new SuccessResult("Article Like added successfully.");
    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkUserExists(int userId) throws UserNotFoundException {

        if(!this.userService.existsById(userId)) {

            throw new UserNotFoundException("User not found! Id: " + userId);
        }
    }

    private void checkArticleExists(int articleId) throws ArticleNotFoundException {

        if(!this.articleLikeDao.existsById(articleId)) {

            throw new ArticleNotFoundException("Article not found! Id: " + articleId);
        }
    }

    private void checkUserArticleAlreadyExists(int userId, int articleId) throws ArticleLikeAlreadyExistsThisUserThisArticleException {

        if(existsByLikeUserAndLikeArticle(this.userService.findById(userId), this.articleService.findById(articleId))) {

            throw new ArticleLikeAlreadyExistsThisUserThisArticleException("This user has already liked this article. UserUd: " + userId + " articleId: " + articleId);
        }
    }

}
