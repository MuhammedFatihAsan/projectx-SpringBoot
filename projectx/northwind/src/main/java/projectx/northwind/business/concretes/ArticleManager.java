package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.User;
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
    private final UserDao userDao;

    @Autowired
    public ArticleManager(ArticleDao articleDao,  UserDao userDao) {

        this.articleDao = articleDao;
        this.userDao = userDao;
    }

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    @Override
    public DataResult<List<ArticleResponseDto>> getAll() {

        List<Article> articles = this.articleDao.findAll();

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "All articles listed !");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);//-1 because it starts pagination from number 0
        List<Article> articles = this.articleDao.findAll(pageable).getContent();

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, pageNo + ". page articles listed!");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAllSortedDesc() {

        Sort sort = Sort.by(Sort.Direction.DESC,"title");
        List<Article> articles = this.articleDao.findAll(sort);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "SortedDesc by title");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getAllSortedAsc() {

        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        List<Article> articles = this.articleDao.findAll(sort);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "SortedAsc by title");

    }

    @Override
    public DataResult<ArticleResponseDto> getByTitle(String title) {

        Article article = this.articleDao.getByTitle(title);

        return new SuccessDataResult<ArticleResponseDto>(ArticleMapper.mapArticleResponseDto(article), "Data listed by title");

    }

    @Override
    public DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(String title, int user_id) {

        Article article = this.articleDao.getByTitleAndArticleUser_Id(title, user_id);

        return new SuccessDataResult<ArticleResponseDto>(ArticleMapper.mapArticleResponseDto(article), "Data listed by title and article user id");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(String title, int user_id) {

        List<Article> articles = this.articleDao.getByTitleOrArticleUser_Id(title, user_id);

        List<ArticleResponseDto> responseDtoList = new ArrayList<>();

        for (Article article : articles) {

            responseDtoList.add(ArticleMapper.mapArticleResponseDto(article));
        }

        return new SuccessDataResult<List<ArticleResponseDto>>(responseDtoList, "Data listed by title or article user id");

    }

    @Override
    public DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(List<Integer> users) {

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

        int authorId = newArticleRequest.getAuthorId();
        User author = userDao.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        newArticle.setArticleUser(author);

        this.articleDao.save(newArticle);

        return new SuccessResult("Article added!");

    }

}
