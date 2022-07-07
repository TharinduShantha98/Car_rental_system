package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDto;

import java.util.List;

public interface DriverService {

    void saveDriver(DriverDto driverDto);
    void searchDriver(String id);
    void deleteDriver(String id);
    void updateDriver(DriverDto driverDto);
    List<DriverDto> getAllDriver();




}
