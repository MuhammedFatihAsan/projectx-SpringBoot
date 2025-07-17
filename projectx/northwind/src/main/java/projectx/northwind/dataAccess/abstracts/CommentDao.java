package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    // =================== INTERNAL METHODS ===================

    boolean existsByBody(String body);

}
