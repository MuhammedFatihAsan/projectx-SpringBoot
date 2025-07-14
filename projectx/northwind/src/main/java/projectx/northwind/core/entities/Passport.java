package projectx.northwind.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Email
    @NotBlank // ""
    @NotNull
    private String mail;

    @Column(name="password_hash")
    @NotBlank // ""
    @NotNull
    private String passwordHash;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)//if passport delete then user delete automatic
    private User user;

}

