package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListByArticleDto {

    private String articleTitle;
    private List<CommentResponseDto> commentsDto;

}
