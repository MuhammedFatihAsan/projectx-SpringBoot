package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projectx.northwind.core.entities.User;

@Entity
@Table(name = "article_like")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @Valid
    @JoinColumn(name = "user_id")
    private User likeUser;

    @ManyToOne
    @Valid
    @JoinColumn(name = "article_id")
    private Article likeArticle;

}
