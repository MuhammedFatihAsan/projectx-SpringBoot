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
    private String userName;
    private int passportId;
    private List<String> articleTitlesWritten;
    private List<String> commentsWritten;
    private List<String> likedArticleTitles;

}
