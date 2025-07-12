package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectx.northwind.entities.concretes.Article;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer> {

    Article getByTitle(String title);

    Article getByTitleAndUser_Id(String title, int user_id);

    List<Article> getByTitleOrUser_Id(String title, int user_id);

    List<Article> getByUser_IdIn(List<Integer> users);

    List<Article> getByTitleContains(String title);

    List<Article> getByTitleStartsWith(String title);

    @Query("From Article a where a.title=:title AND a.user.id=:user_id")
    List<Article> getByNameAndUser(String title, int user_id);
    // like -> select * from article where title = x and user_id = x

}
