package projectx.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleWithUserDto {

    private int articleId;
    private String articleTitle;
    private String userName;

}
