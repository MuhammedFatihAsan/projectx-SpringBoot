package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.article.NoArticlesExistException;
import projectx.northwind.core.exceptions.types.common.ArticleAndUserNotFoundException;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.mapping.ArticleMapper;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.ArticleDao;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.requests.CreateArticleRequestDto;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;
import projectx.northwind.entities.dtos.responses.ArticleWithUserDto;


import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleManager implements ArticleService {

    private final ArticleDao articleDao;
    private final UserService userService;

    @Autowired
    public ArticleManager(ArticleDao articleDao,  UserService userService) {

        this.articleDao = articleDao;
        this.userService = userService;
    }

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    @Override
    public boolean existsByTitle(String title) {

        return this.articleDao.existsByTitle(title);
    }

    @Override
    public boolean existsBy() {

        return this.articleDao.existsBy();
    }

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    @Override
    public DataResult<List<ArticleResponseDto>> getAll() throws NoArticlesExistException {

        checkAnyArticleExists();

        List<Article> articles = this.articleDao.findAll();

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "All articles listed !");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize) throws NoArticlesExistException {

        checkAnyArticleExists();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);//-1 because it starts pagination from number 0
        List<Article> articles = this.articleDao.findAll(pageable).getContent();

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, pageNo + ". page articles listed!");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAllSortedDesc() throws NoArticlesExistException {

        checkAnyArticleExists();

        Sort sort = Sort.by(Sort.Direction.DESC,"title");
        List<Article> articles = this.articleDao.findAll(sort);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "SortedDesc by title");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAllSortedAsc() throws NoArticlesExistException {

        checkAnyArticleExists();

        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        List<Article> articles = this.articleDao.findAll(sort);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "SortedAsc by title");

    }

    @Override
    public DataResult<ArticleResponseDto> getByTitle(String title) throws ArticleNotFoundException {

        checkArticleExistsByTitle(title);

        Article article = this.articleDao.getByTitle(title);

        return new SuccessDataResult<ArticleResponseDto>(ArticleMapper.mapArticleResponseDto(article), "Data listed by title");

    }

    @Override
    public DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(String title, int user_id) throws ArticleNotFoundException, UserNotFoundException {

        checkArticleExistsByTitle(title);
        checkUserExistsById(user_id);

        Article article = this.articleDao.getByTitleAndArticleUser_Id(title, user_id);

        return new SuccessDataResult<ArticleResponseDto>(ArticleMapper.mapArticleResponseDto(article), "Data listed by title and article user id");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(String title, int user_id) throws ArticleAndUserNotFoundException {

        checkArticleExistsByTitleOrUserExistsById(title, user_id);

        List<Article> articles = this.articleDao.getByTitleOrArticleUser_Id(title, user_id);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "Data listed by title or article user id");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(List<Integer> users) throws NoUsersExistsException {

        checkUserExistsByIdList(users);

        List<Article> articles = this.articleDao.getByArticleUser_IdIn(users);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "Data listed by article user id");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByTitleContains(String title) {

        List<Article> articles = this.articleDao.getByTitleContains(title);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "Data listed by title contains");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByTitleStartsWith(String title) {

        List<Article> articles = this.articleDao.getByTitleStartsWith(title);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "Data listed");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByNameAndUser(String title, int user_id) {

        List<Article> articles = this.articleDao.getByNameAndUser(title, user_id);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<>(responseDtoList, "Data listed by title and article user id");

    }

    @Override
    public DataResult<List<ArticleWithUserDto>> getArticleWithUser() {

        return new SuccessDataResult<List<ArticleWithUserDto>>(this.articleDao.getArticleWithUser(), "Data listed");
    }

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    @Override
    public Result add(CreateArticleRequestDto newArticleRequest) {

        Article newArticle = new Article();

        newArticle.setTitle(newArticleRequest.getTitle());
        newArticle.setBody(newArticleRequest.getBody());

//        int authorId = newArticleRequest.getAuthorId();
//        User author = userDao.findById(authorId)
//                .orElseThrow(() -> new RuntimeException("User not found to add article"));

//        newArticle.setArticleUser(author);

        this.articleDao.save(newArticle);

        return new SuccessResult("Article added!");

    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkAnyArticleExists() throws NoArticlesExistException {

        if(!existsBy()){

            throw new NoArticlesExistException("No articles are registered!");
        }
    }

    private void checkArticleExistsByTitle(String title) throws ArticleNotFoundException {

        if(!existsByTitle(title)){

            throw new ArticleNotFoundException(title + " : Not Found!");
        }
    }

    private void checkUserExistsById(int userId) throws UserNotFoundException {

        if(!this.userService.existsById(userId)){

            throw new UserNotFoundException(userId + " : that id not found in users!");
        }
    }

    private void checkArticleExistsByTitleOrUserExistsById(String title, int userId) throws ArticleAndUserNotFoundException {

        if(!existsByTitle(title) && !this.userService.existsById(userId)){

            throw new ArticleAndUserNotFoundException("Article title : " + title + " User id : " + userId + " both are not found!");
        }
    }

    private void checkUserExistsByIdList(List<Integer> userIds) throws NoUsersExistsException {

        for(Integer userId : userIds){

            if(this.userService.existsById(userId)){

                return;
            }
        }

        throw new NoUsersExistsException("None of the user ids are in users!");
    }

}
