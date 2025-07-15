package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projectx.northwind.core.entities.User;
import java.util.List;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotBlank
    @NotNull
    private String title;

    @Column(name = "body")
    @NotBlank
    @NotNull
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User articleUser;

    @OneToMany(mappedBy = "commentArticle")
    private List<Comment> comments;

    @OneToMany(mappedBy = "categoryArticle")
    private List<ArticleCategory> articleCategories;

    @OneToMany(mappedBy = "likeArticle")
    private List<ArticleLike> articleLikes;

}
