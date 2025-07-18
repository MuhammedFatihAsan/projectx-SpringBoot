package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListByUserDto {

    private String userName;
    private List<CommentResponseDto> commentsDto;

}
