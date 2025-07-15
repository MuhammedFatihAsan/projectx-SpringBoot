package projectx.northwind.business.abstracts;

import java.util.List;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;

public interface PassportService {

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<List<Passport>> getAll();

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(Passport passport);

}
