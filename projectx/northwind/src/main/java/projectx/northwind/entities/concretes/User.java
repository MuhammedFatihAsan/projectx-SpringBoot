package projectx.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;

    @OneToOne
    @MapsId // user id comes from passport so same the passport id
    @JoinColumn(name = "id")
    @JsonManagedReference // bu taraf JSON'a yazılsın
    private Passport passport;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
//    @JsonBackReference // bu taraf JSON'a yazılmasın
    private List<Article> articles;

}
