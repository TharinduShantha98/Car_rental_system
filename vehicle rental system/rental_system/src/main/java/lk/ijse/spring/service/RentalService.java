package lk.ijse.spring.service;

import lk.ijse.spring.dto.RentalDto;
import lk.ijse.spring.entity.Rental;

import java.util.List;

public interface RentalService {

    boolean addRental(RentalDto rentalDto);
    RentalDto searchRental(String id);
    boolean updateRental(RentalDto rentalDto);
    boolean deleteRental(String id);
    List<RentalDto> getAllRental();





}
