package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.ArticleCategory;
import projectx.northwind.entities.concretes.Category;

public interface ArticleCategoryDao extends JpaRepository<ArticleCategory, Integer> {

    // =================== INTERNAL METHODS ===================

    boolean existsByCategoryArticleAndArticleCategory(Article categoryArticle, Category articleCategory);

}
