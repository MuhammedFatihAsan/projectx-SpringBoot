package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponseDto {

    private int articleId;
    private String title;
    private String body;
    private String author;
    private List<String> tags;

}
