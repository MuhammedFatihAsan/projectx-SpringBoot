package projectx.northwind.core.exceptions.types.articleLike;

import projectx.northwind.core.exceptions.base.BusinessException;

public class ArticleLikeAlreadyExistsThisUserThisArticleException extends BusinessException {

    public ArticleLikeAlreadyExistsThisUserThisArticleException(String message) {

        super(message);
    }
}
