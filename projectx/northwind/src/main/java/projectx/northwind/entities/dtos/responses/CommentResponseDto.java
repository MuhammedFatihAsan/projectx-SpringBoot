package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {

    private int id;
    private String body;
    private String userName;
    private String articleTitle;

}
