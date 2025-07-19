package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.core.entities.User;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.ArticleLike;

public interface ArticleLikeDao extends JpaRepository<ArticleLike, Integer> {

    // =================== INTERNAL METHODS ===================

    boolean existsByLikeUserAndLikeArticle(User likeUser, Article likeArticle);

}
