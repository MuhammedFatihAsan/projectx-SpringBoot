package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @Valid
    @JoinColumn(name = "article_id")
    private Article categoryArticle;

    @ManyToOne
    @Valid
    @JoinColumn(name = "category_id")
    private Category articleCategory;

}
