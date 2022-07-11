package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
            return false;
        }



    }
}
