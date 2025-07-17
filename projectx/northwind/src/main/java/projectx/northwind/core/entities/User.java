package projectx.northwind.core.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.ArticleLike;
import projectx.northwind.entities.concretes.Comment;
import java.util.List;

@Entity
@Table(name = "\"user\"") // "user" is a reserved keyword
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank
    @NotNull
    private String name;

    @OneToOne
    @MapsId // user id comes from passport so same the passport id
    @Valid
    @JoinColumn(name = "id")
    private Passport passport;

    @OneToMany(mappedBy = "articleUser", orphanRemoval = true)
    private List<Article> articles;

    @OneToMany(mappedBy = "commentUser", orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "likeUser",  orphanRemoval = true)
    private List<ArticleLike>  likedArticles;

}

