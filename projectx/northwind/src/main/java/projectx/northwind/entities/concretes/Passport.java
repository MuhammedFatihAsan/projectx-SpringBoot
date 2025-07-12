package projectx.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="passport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"}) // Prevent recursive JSON output
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="mail")
    private String mail;

    @Column(name="password_hash")
    private String passwordHash;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)//if passport delete then user delete automatic
//    @JsonBackReference // bu taraf JSON'a yazılmasın
    private User user;

}
