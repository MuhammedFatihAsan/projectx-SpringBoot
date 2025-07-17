package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.CommentService;
import projectx.northwind.dataAccess.abstracts.CommentDao;

@Service
public class CommentManager implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentManager(CommentDao commentDao) {

        this.commentDao = commentDao;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByBody(String body) {

        return this.commentDao.existsByBody(body);
    }

}
