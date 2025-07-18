package projectx.northwind.business.abstracts;

import java.util.List;

import projectx.northwind.core.exceptions.types.passport.MailAlreadyExistsException;
import projectx.northwind.core.exceptions.types.passport.NoPassportExistsException;
import projectx.northwind.core.exceptions.types.user.UserAlreadyExistsException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreatePassportWithUserDto;
import projectx.northwind.entities.dtos.responses.PassportResponseDto;

public interface PassportService {

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    boolean existsByMail(String mail);

    boolean existsBy();

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<List<PassportResponseDto>> getAll() throws NoPassportExistsException;

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(CreatePassportWithUserDto newPassportUser) throws UserAlreadyExistsException, MailAlreadyExistsException;

}
