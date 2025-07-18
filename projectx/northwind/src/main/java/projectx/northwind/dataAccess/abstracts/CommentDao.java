package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Comment;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    // =================== INTERNAL METHODS ===================

    boolean existsByBody(String body);

    boolean existsBy();

    // =================== RESPONSE METHODS ===================

    List<Comment> getAllByCommentUser_Id(Integer userId);

}
