package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDto;

import java.util.List;

public interface DriverService {

    void saveDriver(DriverDto driverDto);
    DriverDto searchDriver(String id);
    void deleteDriver(String id);
    void updateDriver(DriverDto driverDto);
    List<DriverDto> getAllDriver();
    List<String> availableDrivers();
    String nextDriverId();







}
