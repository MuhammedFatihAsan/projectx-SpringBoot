package projectx.northwind.core.entities;

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

    // (tr): Cascade(şelale) = Şelale etkisi gibi düşünebilirsin. Passport üzerinde yapılan işlemler (ekleme, silme),
    //     ilişkili User'a da otomatik olarak uygulanır. Bir yerde başlar, zincirleme şekilde diğerine yayılır.
    // (en): Cascade works like a waterfall effect. Any operation on Passport (save, delete)
    //     is automatically applied to the related User. Starts at one point and flows down to others.
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private User user;

}

