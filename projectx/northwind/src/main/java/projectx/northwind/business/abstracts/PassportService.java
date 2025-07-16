package projectx.northwind.business.abstracts;

import java.util.List;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreatePassportWithUserDto;

public interface PassportService {

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    boolean existsByMail(String mail);

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<List<Passport>> getAll();

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(CreatePassportWithUserDto newPassportUser);

}
