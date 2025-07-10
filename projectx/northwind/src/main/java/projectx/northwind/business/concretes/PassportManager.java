package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired; // bean -> class proje class'ı
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.PassportService;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.PassportDao;
import projectx.northwind.entities.concretes.Passport;
import java.util.List;

@Service
public class PassportManager implements PassportService {

    private PassportDao passportDao;

    @Autowired
    public PassportManager(PassportDao passportDao) {
        this.passportDao = passportDao;
    }

    @Override
    public DataResult<List<Passport>> getAll() {

        return new SuccessDataResult<>(this.passportDao.findAll(), "Data listed");
    }

    @Override
    public Result add(Passport passport) {

        this.passportDao.save(passport);
        return new SuccessResult("Passport added!");
    }

}
