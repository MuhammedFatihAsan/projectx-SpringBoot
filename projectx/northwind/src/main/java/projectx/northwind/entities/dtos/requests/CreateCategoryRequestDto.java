package projectx.northwind.entities.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequestDto {

    @NotNull
    @NotBlank
    @Length(max = 50, message = "Category name must be most 50 characters")
    private String categoryName;

}
