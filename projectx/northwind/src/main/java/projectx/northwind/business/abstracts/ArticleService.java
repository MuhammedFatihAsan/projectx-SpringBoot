package projectx.northwind.business.abstracts;

import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.article.NoArticlesExistException;
import projectx.northwind.core.exceptions.types.article.TitleAlreadyExistsException;
import projectx.northwind.core.exceptions.types.common.ArticleAndUserNotFoundException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.requests.CreateArticleRequestDto;
import projectx.northwind.entities.dtos.requests.UpdateArticleContentRequestDto;
import projectx.northwind.entities.dtos.requests.UpdateArticleTitleRequestDto;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;
import projectx.northwind.entities.dtos.responses.ArticleWithUserDto;

import java.util.List;

public interface ArticleService {

    // =================== INTERNAL METHODS ===================

    boolean existsByTitle(String title);

    boolean existsBy();

    boolean existsById(int articleId);

    Article findById(int articleId);

    List<Article> getAllArticles() throws NoArticlesExistException;

    // =================== RESPONSE METHODS ===================

    DataResult<List<ArticleResponseDto>> getAll() throws NoArticlesExistException;

    DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize) throws NoArticlesExistException;

    DataResult<List<ArticleResponseDto>> getAllSortedDesc() throws NoArticlesExistException;

    DataResult<List<ArticleResponseDto>> getAllSortedAsc() throws NoArticlesExistException;

    DataResult<ArticleResponseDto> getByTitle(String title) throws ArticleNotFoundException;

    DataResult<ArticleResponseDto> getById(int articleId) throws ArticleNotFoundException;

    DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(String title, int user_id) throws ArticleNotFoundException, UserNotFoundException;

    DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(String title, int user_id) throws ArticleAndUserNotFoundException;

    DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(List<Integer> users) throws NoUsersExistsException;

    DataResult<List<ArticleResponseDto>> getByTitleContains(String title) throws EmptyListException;

    DataResult<List<ArticleResponseDto>> getByTitleStartsWith(String title) throws EmptyListException;

    DataResult<List<ArticleResponseDto>> getByNameAndUser(String title, int user_id) throws EmptyListException;

    DataResult<List<ArticleWithUserDto>> getArticleWithUser() throws NoArticlesExistException, NoUsersExistsException;

    // =================== REQUEST METHODS ===================

    Result add(CreateArticleRequestDto newArticle) throws UserNotFoundException, TitleAlreadyExistsException;

    Result updateArticleContent(UpdateArticleContentRequestDto updateArticleContentDto) throws ArticleNotFoundException;

    Result updateArticleTitle(UpdateArticleTitleRequestDto updateArticleTitleDto) throws ArticleNotFoundException, TitleAlreadyExistsException;

}
