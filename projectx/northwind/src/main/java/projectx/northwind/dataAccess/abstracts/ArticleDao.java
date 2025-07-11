package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectx.northwind.entities.concretes.Article;
import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer> {

    Article getByTitle(String title);

    Article getByTitleAndUser(String title, int user_id);

    List<Article> getByTitleOrUser(String title, int user_id);

    List<Article> getByUserIn(List<Integer> users);

    List<Article> getByTitleContains(String title);

    List<Article> getByTitleStartsWith(String title);

    @Query("From Article a where a.title=:title AND a.user_id=:user_id")
    List<Article> getByNameAndUser(String title, int user_id);
    // like -> select * from article where title = x and user_id = x

}
