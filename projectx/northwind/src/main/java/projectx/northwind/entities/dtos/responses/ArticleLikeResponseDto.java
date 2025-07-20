package projectx.northwind.entities.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeResponseDto {

    private String articleTitle;
    private int likeCount;
    private List<String> likedUserNames;

}
