package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CarServiceImpl  implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public boolean saveCar(CarDto carDto) {
        if (!carRepo.existsById(carDto.getCarId())) {
            carRepo.save(modelMapper.map(carDto,Car.class));
            return true;
        }else{
            throw  new RuntimeException("this car already exists");
        }

    }

    @Override
    public CarDto searchCar(String id) {
        if(carRepo.existsById(id)){
            Optional<Car> byId = carRepo.findById(id);
            return modelMapper.map(byId.get(),CarDto.class);

        }else{
            throw new RuntimeException("this car not found in database");
        }
    }

    @Override
    public boolean updateCar(CarDto carDto) {
        if(carRepo.existsById(carDto.getCarId())){
            carRepo.save(modelMapper.map(carDto,Car.class));
            return true;
        }else{
            throw new RuntimeException("this car not found in database");
        }

    }

    @Override
    public boolean deleteCar(String id) {
      if(carRepo.existsById(id)){
          carRepo.deleteById(id);
          return true;
      }else{
          throw new RuntimeException("this car id not found in database");
      }
    }

    @Override
    public List<CarDto> getAllCars() {

        List<Car> all = carRepo.findAll();
        List<CarDto> allCars = new ArrayList<>();

        for (Car c1: all
             ) {
            allCars.add(modelMapper.map(c1,CarDto.class));
        }
        return allCars;

    }



}
