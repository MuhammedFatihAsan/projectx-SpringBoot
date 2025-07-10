package projectx.northwind.business.abstracts;

import java.util.List;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Passport;

public interface PassportService {

    DataResult<List<Passport>> getAll();
    Result add(Passport passport);

}
