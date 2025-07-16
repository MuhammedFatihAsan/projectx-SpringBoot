package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.PassportService;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreatePassportWithUserDto;

import java.util.List;

@RestController
@RequestMapping("/api/passports")
public class PassportsController {

    private final PassportService passportService;

    @Autowired
    public PassportsController(PassportService passportService) {

        this.passportService = passportService;
    }

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    @GetMapping("/getAll")
    public DataResult<List<Passport>> getAll(){

        return this.passportService.getAll();
    }

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    @PostMapping("/add")
    public Result add(@RequestBody CreatePassportWithUserDto newPassportUser){

        return this.passportService.add(newPassportUser);
    }

}
