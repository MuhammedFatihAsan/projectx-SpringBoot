package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleCategoryRequestDto {

    @NotNull(message = "ArticleId cannot be NULL")
    private int articleId;

    @NotNull(message = "CategoryId cannot be NULL")
    private int categoryId;

}
