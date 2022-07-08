package lk.ijse.spring.controller;


import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
@CrossOrigin

public class DriverController {

    @Autowired
    DriverService driverService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil setDriver(DriverDto driverDto){
        driverService.saveDriver(driverDto);
        return  new ResponseUtil(200,"Successful added Driver for database", null);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriver(){
        List<DriverDto> allDriver = driverService.getAllDriver();
        return  new ResponseUtil(200,"successful get all Drivers",allDriver);

    }


    @GetMapping(value = "search", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@RequestParam String id){
        DriverDto driverDto = driverService.searchDriver(id);
        return  new ResponseUtil(200,"search Driver successful",driverDto);
    }

    @DeleteMapping(params = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(String id){
        driverService.deleteDriver(id);
        return new ResponseUtil(200, "delete driver successful",null);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDto driverDto){
        driverService.updateDriver(driverDto);
        return  new ResponseUtil(200,"successful update driver",null);

    }


}
