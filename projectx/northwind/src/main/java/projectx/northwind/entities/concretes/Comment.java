package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projectx.northwind.core.entities.User;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User commentUser;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article commentArticle;

}
