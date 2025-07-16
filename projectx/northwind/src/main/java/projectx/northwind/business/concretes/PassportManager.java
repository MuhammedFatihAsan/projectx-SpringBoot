package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.PassportService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.PassportDao;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.entities.dtos.requests.CreatePassportWithUserDto;
import projectx.northwind.entities.dtos.responses.PassportResponseDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PassportManager implements PassportService {

    private final PassportDao passportDao;
    private final UserDao userDao;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder; // Used for hashing and verifying passwords

    @Autowired
    public PassportManager(PassportDao passportDao, UserDao userDao, UserService userService, PasswordEncoder passwordEncoder) {

        this.passportDao = passportDao;
        this.userDao = userDao;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    @Override
    public boolean existsByMail(String mail) {

        return this.passportDao.existsByMail(mail);
    }

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    @Override
    public DataResult<List<PassportResponseDto>> getAll() {

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
    // (Operations that retrieve, save or modify new data)

    @Override
    public Result add(CreatePassportWithUserDto dto) {

        if(!this.userService.existsByName(dto.getUserName())){

            if(!existsByMail(dto.getMail())){

                Passport newPassport = new Passport();
                newPassport.setMail(dto.getMail());
                newPassport.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

                User newUser = new User();
                newUser.setName(dto.getUserName());
                newUser.setPassport(newPassport);

                newPassport.setUser(newUser);

                // SADECE passport'ı kaydet
                passportDao.save(newPassport); // User da cascade ile kaydedilir

                return new SuccessResult("Created with the new passport user !");
            }
        }

        return new Result(false, "Error! Passport creation failed !");
    }

}
