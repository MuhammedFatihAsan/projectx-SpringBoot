package projectx.northwind.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @MapsId // user id comes from passport so same the passport id
    @JoinColumn(name = "id")
    private Passport passport;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Article> articles;

}
