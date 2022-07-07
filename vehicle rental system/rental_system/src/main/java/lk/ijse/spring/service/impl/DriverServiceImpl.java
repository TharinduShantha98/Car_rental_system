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
    public void addDriver(DriverDto driverDto) {
        driverRepo.save(modelMapper.map(driverDto, Driver.class));

    }

    @Override
    public List<DriverDto> getAllDriver() {
        return null;
    }


}
