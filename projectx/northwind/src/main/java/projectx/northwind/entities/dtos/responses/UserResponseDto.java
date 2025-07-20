package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private int id;
    private String userName;
    private int passportId;
    private List<String> articleTitlesWritten;
    private Map<String, List<String>> commentsWritten;
    private List<String> likedArticleTitles;

}
