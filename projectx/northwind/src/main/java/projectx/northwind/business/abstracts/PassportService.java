package projectx.northwind.business.abstracts;

import java.util.List;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;

public interface PassportService {

    DataResult<List<Passport>> getAll();
    Result add(Passport passport);

}
