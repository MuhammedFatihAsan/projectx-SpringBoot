package projectx.northwind.business.abstracts;

import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateArticleRequestDto;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;
import projectx.northwind.entities.dtos.responses.ArticleWithUserDto;

import java.util.List;

public interface ArticleService {

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    boolean existsByTitle(String title);

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<List<ArticleResponseDto>> getAll();

    DataResult<List<ArticleResponseDto>> getAll(int pageNo, int pageSize);

    DataResult<List<ArticleResponseDto>> getAllSortedDesc();

    DataResult<List<ArticleResponseDto>> getAllSortedAsc();

    DataResult<ArticleResponseDto> getByTitle(String title);

    DataResult<ArticleResponseDto> getByTitleAndArticleUser_Id(String title, int user_id);

    DataResult<List<ArticleResponseDto>> getByTitleOrArticleUser_Id(String title, int user_id);

    DataResult<List<ArticleResponseDto>> getByArticleUser_IdIn(List<Integer> users);

    DataResult<List<ArticleResponseDto>> getByTitleContains(String title);

    DataResult<List<ArticleResponseDto>> getByTitleStartsWith(String title);

    DataResult<List<ArticleResponseDto>> getByNameAndUser(String title, int user_id);

    DataResult<List<ArticleWithUserDto>> getArticleWithUser();

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(CreateArticleRequestDto newArticle);

}
