package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequestDto {

    @NotNull(message = "Comment body cannot be NULL")
    @NotBlank(message = "Comment body cannot be BLANK")
    @Size(min = 2, message = "Comment must be least 2 characters")
    private String commentBody;

    @NotNull(message = "UserId cannot be NULL")
    private int userId;

    @NotNull(message = "ArticleId cannot be NULL")
    private int articleId;

}
