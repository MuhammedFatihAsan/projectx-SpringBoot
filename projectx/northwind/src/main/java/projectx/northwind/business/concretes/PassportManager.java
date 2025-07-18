package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.PassportService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.PassportDao;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.passport.MailAlreadyExistsException;
import projectx.northwind.core.exceptions.types.passport.NoPassportExistsException;
import projectx.northwind.core.exceptions.types.user.UserAlreadyExistsException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.entities.dtos.requests.CreatePassportWithUserDto;
import projectx.northwind.entities.dtos.responses.PassportResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassportManager implements PassportService {

    private final PassportDao passportDao;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder; // Used for hashing and verifying passwords

    @Autowired
    public PassportManager(PassportDao passportDao, UserService userService, PasswordEncoder passwordEncoder) {

        this.passportDao = passportDao;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByMail(String mail) {

        return this.passportDao.existsByMail(mail);
    }

    @Override
    public boolean existsBy() {

        return this.passportDao.existsBy();
    }

    // =================== RESPONSE METHODS ===================

    @Override
    public DataResult<List<PassportResponseDto>> getAll() throws NoPassportExistsException {

        checkAnyPassportExists();

        List<Passport> passports = this.passportDao.findAll();

        List<PassportResponseDto> responseDtoList = new ArrayList<>();

        for (Passport passport : passports){

            PassportResponseDto dto = new PassportResponseDto();

            dto.setPassportId(passport.getId());
            dto.setMail(passport.getMail());
            dto.setUserName(passport.getUser().getName());

            responseDtoList.add(dto);

        }

        return new SuccessDataResult<List<PassportResponseDto>>(responseDtoList, "Data listed");
    }

    // =================== REQUEST METHODS ===================

    @Override
    public Result add(CreatePassportWithUserDto dto) throws UserAlreadyExistsException, MailAlreadyExistsException {

        checkUserAlreadyExists(dto.getUserName());
        checkMailAlreadyExists(dto.getMail());

        Passport newPassport = new Passport();
        newPassport.setMail(dto.getMail());
        newPassport.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

        User newUser = new User();
        newUser.setName(dto.getUserName());
        newUser.setPassport(newPassport);

        newPassport.setUser(newUser);

        // (tr): Sadece passport kaydedilerek ilişkili user da otomatik kaydedilir (cascade sayesinde)
        // (en): Only passport is saved, and the related user is also persisted automatically (thanks to cascade)
        passportDao.save(newPassport);

        return new SuccessResult("Created with the new passport user !");

    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkAnyPassportExists() throws NoPassportExistsException {

        if(!existsBy()){

            throw new NoPassportExistsException("No passport are registered!");
        }
    }

    private void checkUserAlreadyExists(String userName) throws UserAlreadyExistsException {

        if(this.userService.existsByName(userName)){

            throw new UserAlreadyExistsException("User with name " + userName + " already exists !");
        }
    }

    private void checkMailAlreadyExists(String mail) throws MailAlreadyExistsException {

        if(existsByMail(mail)){

            throw new MailAlreadyExistsException(mail + " : Mail already exists !");
        }
    }

}
