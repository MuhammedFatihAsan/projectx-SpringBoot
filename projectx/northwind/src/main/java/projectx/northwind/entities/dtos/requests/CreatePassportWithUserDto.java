package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePassportWithUserDto {

    @NotNull
    @NotBlank
    @Email
    @Size(max = 255)
    private String mail;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 100)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "Password must contain at least 1 uppercase letter, 1 lowercase letter" +
                    ", 1 number and be longer than 8 characters.")
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String userName;

}
