package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @NotNull
    @Column(name = "body")
    private String body;

    @ManyToOne
    @Valid
    @JoinColumn(name = "user_id")
    private User commentUser;

    @ManyToOne
    @Valid
    @JoinColumn(name = "article_id")
    private Article commentArticle;

}
