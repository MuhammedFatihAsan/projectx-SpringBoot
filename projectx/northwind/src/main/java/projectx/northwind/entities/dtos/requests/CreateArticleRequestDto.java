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
public class CreateArticleRequestDto {

    @NotNull(message = "Title cannot be NULL")
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters")
    private String title;

    @NotNull(message = "Body cannot be NULL")
    @NotBlank(message = "Body cannot be blank")
    private String body;

    @NotNull(message = "AuthorId cannot be NULL")
    private int authorId;

}
