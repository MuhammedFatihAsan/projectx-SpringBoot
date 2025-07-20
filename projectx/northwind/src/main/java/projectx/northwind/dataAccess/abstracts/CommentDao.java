package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Comment;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    boolean existsByBody(String body);

    boolean existsBy();

    boolean existsById(int commentId);

    Comment findById(int commentId);

    List<Comment> getAllByCommentUser_Id(Integer userId);

    List<Comment> getAllByCommentArticle_Id(Integer userId);

}
