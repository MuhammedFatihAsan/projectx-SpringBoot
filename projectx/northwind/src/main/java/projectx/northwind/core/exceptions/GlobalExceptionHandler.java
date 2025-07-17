package projectx.northwind.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import projectx.northwind.core.exceptions.base.BusinessException;
import projectx.northwind.core.utilities.results.ErrorDataResult;
import projectx.northwind.core.utilities.results.ErrorResult;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<String, String>();

        // (tr): Tüm field (alan) hataları alınır ve field adı ile mesaj map'e eklenir
        // (en): All field errors are retrieved and added to the map with the field name and message
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // (tr): Hazırlanan hata detayları, özelleştirilmiş bir hata veri sonucu (ErrorDataResult) ile paketlenir
        // (en): The prepared validation error details are wrapped in a custom error data result (ErrorDataResult)
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Error!");

        return errors;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleBusinessException(BusinessException ex) {

        return new ErrorResult(ex.getMessage());
    }

}
