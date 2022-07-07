package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;



    @Override
    public void saveDriver(DriverDto driverDto) {
        if(!driverRepo.existsById(driverDto.getDriverId())){
            driverRepo.save(modelMapper.map(driverDto, Driver.class));

        }else{
            throw new RuntimeException("This driver"+ driverDto.getDriverId()+ "already exist");
        }
    }

    @Override
    public void searchDriver(String id) {

    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public void updateDriver(DriverDto driverDto) {

    }

    @Override
    public List<DriverDto> getAllDriver() {
        return null;
    }


}
