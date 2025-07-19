package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.responses.ArticleWithUserDto;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer> {

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    boolean existsByTitle(String title);

    boolean existsBy();

    boolean existsById(int articleId);

    Article findById(int articleId);

    // =================== RESPONSE METHODS ===================

    Article getByTitle(String title);

    Article getByTitleAndArticleUser_Id(String title, int user_id);

    List<Article> getByTitleOrArticleUser_Id(String title, int user_id);

    List<Article> getByArticleUser_IdIn(List<Integer> users);

    List<Article> getByTitleContains(String title);

    List<Article> getByTitleStartsWith(String title);

    @Query("From Article a where a.title=:title AND a.articleUser.id=:user_id")
    List<Article> getByNameAndUser(String title, int user_id);
    // like -> select * from article where title = x and user_id = x

    @Query("Select new projectx.northwind.entities.dtos.responses.ArticleWithUserDto (a.id, a.title, u.name) From User u Inner Join u.articles a")
    List<ArticleWithUserDto> getArticleWithUser();
    /* SQL state :
     select a.id, a.title, u.name
     from User u
     inner join Article a on u.id = a.user_id
     ***Note 1 :
     (en) : Query fields have to be in the order of DTO constructor parameters !!!
     (tr) : Query alanları DTO constructor parametrelerinin sıralamasına göre olmak zorunda !!!
     ***Note 2 :
     (en) : For SQL, the names of the table columns are used, but for JPQL (@Query) it is
     mandatory to use the variable names in the Entity class. Because JPA always looks at the
     variable names in the Entity class.
     (tr) : SQL için tablo sütunlarının isimleri kullanılır ama JPQL(@Query) için Entity sınıfı
     içindeki değişken isimlerini kullanmak zorunludur. Çünkü JPA her zaman Entity sınıfındaki
     değişken isimlerine bakar.
     */

}
