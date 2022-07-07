package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDto;

import java.util.List;

public interface DriverService {

    void addDriver(DriverDto driverDto);
    void searchDriver(String id);


    List<DriverDto> getAllDriver();




}
