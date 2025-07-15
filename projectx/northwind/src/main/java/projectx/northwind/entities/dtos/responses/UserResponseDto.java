package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private int id;
    private String username;
    private int passportId;
    private List<String> articleTitlesWritten;


    // tamamlanmamış sınıf !!!

}
