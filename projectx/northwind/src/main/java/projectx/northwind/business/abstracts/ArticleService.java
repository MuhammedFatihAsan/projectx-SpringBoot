package projectx.northwind.business.abstracts;

import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import java.util.List;

public interface ArticleService {

    DataResult<List<Article>> getAll();

    Result add(Article article);

    DataResult<Article> getByTitle(String title);

    DataResult<Article> getByTitleAndUser_Id(String title, int user_id);

    DataResult<List<Article>> getByTitleOrUser_Id(String title, int user_id);

    DataResult<List<Article>> getByUser_IdIn(List<Integer> users);

    DataResult<List<Article>> getByTitleContains(String title);

    DataResult<List<Article>> getByTitleStartsWith(String title);

    DataResult<List<Article>> getByNameAndUser(String title, int user_id);

}
