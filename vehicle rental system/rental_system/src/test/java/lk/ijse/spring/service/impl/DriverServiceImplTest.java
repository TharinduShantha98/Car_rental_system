package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith({SpringExtension.class})
//@Transactional
class DriverServiceImplTest {



    @Autowired
    DriverRepo driverRepo;


    @Test
    void saveDriver() {
        Driver driver = new Driver(
                "D-101",
                "supul",
                "kanchana",
                25,
                "0754564554",
                "1234567890","available");


        if(!driverRepo.existsById(driver.getDriverId())){
            driverRepo.save(driver);
            System.out.println("Driver save successFully");
        }else{
            throw new RuntimeException("driver already exists");
        }



    }

    @Test
    void searchDriver() {


    }

    @Test
    void deleteDriver() {
    }

    @Test
    void updateDriver() {
    }

    @Test
    void getAllDriver() {

        List<Driver> all = driverRepo.findAll();

        if(!all.isEmpty()){
            for (Driver d:all
            ) {
                System.out.println(d);
            }

        }else{
            System.out.println("please input customer for database!..");
        }



    }
}