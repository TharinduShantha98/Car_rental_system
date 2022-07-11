package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDto;

import java.util.List;

public interface CarService {


    boolean saveCar(CarDto carDto);
    CarDto searchCar(String id);
    boolean updateCar(CarDto carDto);
    boolean deleteCar(String id);
    List<CarDto> getAllCars();



}
