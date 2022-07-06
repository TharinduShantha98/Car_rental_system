package lk.ijse.spring.controller;


import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
@CrossOrigin

public class DriverController {

    @Autowired
    DriverService driverService;


    @PostMapping
    public void setCustomer(DriverDto driverDto){
        driverService.addDriver(driverDto);



    }



}
