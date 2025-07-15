package projectx.northwind.business.abstracts;

import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.ArticleWithUserDto;

import java.util.List;

public interface ArticleService {

    DataResult<List<Article>> getAll();

    DataResult<List<Article>> getAll(int pageNo, int pageSize);

    DataResult<List<Article>> getAllSortedDesc();

    DataResult<List<Article>> getAllSortedAsc();

    Result add(Article article);

    DataResult<Article> getByTitle(String title);

    DataResult<Article> getByTitleAndArticleUser_Id(String title, int user_id);

    DataResult<List<Article>> getByTitleOrArticleUser_Id(String title, int user_id);

    DataResult<List<Article>> getByArticleUser_IdIn(List<Integer> users);

    DataResult<List<Article>> getByTitleContains(String title);

    DataResult<List<Article>> getByTitleStartsWith(String title);

    DataResult<List<Article>> getByNameAndUser(String title, int user_id);

    DataResult<List<ArticleWithUserDto>> getArticleWithUser();

}
