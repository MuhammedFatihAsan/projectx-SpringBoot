package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleContentRequestDto {

    @NotNull(message = "ArticleID can NOT be NULL !")
    @Min(value = 1, message = "Article ID must be greater than or equal to 1")
    private int articleId;

    @NotNull(message = "ArticleContent can NOT be NULL !")
    @NotBlank(message = "Article content must not be blank")
    private String articleContent;

}
