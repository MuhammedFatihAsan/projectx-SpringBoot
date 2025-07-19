package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateArticleLikeRequestDto {

    @NotNull(message = "UserId cannot be NULL")
    private int UserId;

    @NotNull(message = "ArticleId cannot be NULL")
    private int ArticleId;

}
