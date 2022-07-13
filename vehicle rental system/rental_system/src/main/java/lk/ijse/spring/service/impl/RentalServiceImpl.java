package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RentalDto;
import lk.ijse.spring.entity.Rental;
import lk.ijse.spring.repo.RentalRepo;
import lk.ijse.spring.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RentalServiceImpl  implements RentalService {

    @Autowired
    RentalRepo rentalRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public boolean addRental(RentalDto rentalDto) {




        return false;
    }
}
