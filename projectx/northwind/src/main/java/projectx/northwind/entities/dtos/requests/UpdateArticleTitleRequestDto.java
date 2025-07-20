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
public class UpdateArticleTitleRequestDto {

    @NotNull(message = "ArticleID can NOT be NULL !")
    @Min(value = 1, message = "Article ID must be greater than or equal to 1")
    private int articleId;

    @NotNull(message = "ArticleTitle can NOT be NULL !")
    @NotBlank(message = "Article title can NOT be BLANK !")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters")
    private String articleTitle;

}
