package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.ArticleDao;
import projectx.northwind.entities.concretes.Article;


import java.util.List;

@Service
public class ArticleManager implements ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public ArticleManager(ArticleDao articleDao) {

        this.articleDao = articleDao;
    }

    @Override
    public DataResult<List<Article>> getAll() {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.findAll(), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);//-1 because it starts pagination from number 0

        return new SuccessDataResult<List<Article>>
                (this.articleDao.findAll(pageable).getContent(), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getAllSortedDesc() {

        Sort sort = Sort.by(Sort.Direction.DESC,"title");

        return new SuccessDataResult<List<Article>>
                (this.articleDao.findAll(sort), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getAllSortedAsc() {

        Sort sort = Sort.by(Sort.Direction.ASC, "title");

        return new SuccessDataResult<List<Article>>
                (this.articleDao.findAll(sort), "Data listed");
    }

    @Override
    public Result add(Article article) {

        this.articleDao.save(article);
        return new SuccessResult("Article added!");
    }

    @Override
    public DataResult<Article> getByTitle(String title) {

        return new SuccessDataResult<Article>
                (this.articleDao.getByTitle(title), "Data listed");
    }

    @Override
    public DataResult<Article> getByTitleAndUser_Id(String title, int user_id) {

        //business codes

        return new SuccessDataResult<Article>
                (this.articleDao.getByTitleAndUser_Id(title, user_id), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getByTitleOrUser_Id(String title, int user_id) {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.getByTitleOrUser_Id(title, user_id), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getByUser_IdIn(List<Integer> users) {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.getByUser_IdIn(users), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getByTitleContains(String title) {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.getByTitleContains(title), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getByTitleStartsWith(String title) {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.getByTitleStartsWith(title), "Data listed");
    }

    @Override
    public DataResult<List<Article>> getByNameAndUser(String title, int user_id) {

        return new SuccessDataResult<List<Article>>
                (this.articleDao.getByNameAndUser(title, user_id), "Data listed");
    }

}
