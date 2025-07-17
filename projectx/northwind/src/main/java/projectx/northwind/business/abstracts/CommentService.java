package projectx.northwind.business.abstracts;

public interface CommentService {

    // =================== INTERNAL METHODS ===================

    boolean existsByBody(String body);

}
