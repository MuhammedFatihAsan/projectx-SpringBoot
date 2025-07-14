package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.PassportService;
import projectx.northwind.core.entities.Passport;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import java.util.List;

@RestController
@RequestMapping("/api/passports")
public class PassportsController {

    private final PassportService passportService;

    @Autowired
    public PassportsController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Passport>> getAll(){

        return this.passportService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Passport passport){

        return this.passportService.add(passport);
    }

}
