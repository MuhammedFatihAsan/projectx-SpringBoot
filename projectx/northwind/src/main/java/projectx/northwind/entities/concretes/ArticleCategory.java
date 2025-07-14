package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article categoryArticle;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category articleCategory;

}
