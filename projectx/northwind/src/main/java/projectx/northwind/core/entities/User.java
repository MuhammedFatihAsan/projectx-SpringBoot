package projectx.northwind.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projectx.northwind.entities.concretes.Article;

import java.util.List;

@Entity
@Table(name = "\"user\"") // "user" is a reserved keyword
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "articles"}) // Prevent recursive JSON output
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
    @JoinColumn(name = "id")
    private Passport passport;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Article> articles;

}

