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
public class UpdateCommentRequestDto {

    @NotNull(message = "CommentId can NOT be NULL !")
    private int commentId;

    @NotNull(message = "Comment body can NOT be NULL !")
    @NotBlank(message = "Comment body can NOT be BLANK !")
    @Size(min = 2, message = "Comment body must be least 2 characters")
    private String commentBody;

}
