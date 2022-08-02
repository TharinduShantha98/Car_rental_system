package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.RentalDto;
import lk.ijse.spring.entity.Rental;
import lk.ijse.spring.repo.RentalRepo;
import lk.ijse.spring.service.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalServiceImpl  implements RentalService {

    @Autowired
    RentalRepo rentalRepo;

    @Autowired
    ModelMapper modelMapper;





    @Override
    public boolean addRental(RentalDto rentalDto) {

        if(!rentalRepo.existsById(rentalDto.getRentalId())){
            rentalRepo.save(modelMapper.map(rentalDto,Rental.class));
            return true;

        }else{
            throw  new RuntimeException("this rental is already exists");
        }







    }

    @Override
    public RentalDto searchRental(String id) {
        if(rentalRepo.existsById(id)){
            Optional<Rental> byId = rentalRepo.findById(id);
            return modelMapper.map(byId.get(),RentalDto.class);

        }else{
            throw  new RuntimeException("this id is not fond");
        }


    }

    @Override
    public boolean updateRental(RentalDto rentalDto) {
        if(rentalRepo.existsById(rentalDto.getRentalId())){
           rentalRepo.save(modelMapper.map(rentalDto,Rental.class));

           return true;
        }else{
            throw new RuntimeException("this is is not found");
        }



    }

    @Override
    public boolean deleteRental(String id) {

        if(rentalRepo.existsById(id)){
           rentalRepo.deleteById(id);

           return true;
        }else{
            throw new RuntimeException("this is is not found");
        }


    }

    @Override
    public List<RentalDto> getAllRental() {
        List<RentalDto> allRentals = new ArrayList<>();
        List<Rental> all = rentalRepo.findAll();
        for (Rental r1: all
             ) {
            allRentals.add(modelMapper.map(r1,RentalDto.class));
        }
        return  allRentals;
    }

    @Override
    public  String getLastId() {
        Rental lastRental = rentalRepo.findTopByOrderByRentalIdDesc();
        String rentalId = lastRental.getRentalId();

        if (lastRental != null) {

            int tempId = Integer.parseInt(rentalId.split("-")[1]);
            tempId = tempId +1;
            return  "R-" + tempId;

        }else{
            return "R-100";
        }





    }

    @Override
    public List<RentalDto> getAllReturnDateRental() {
        List<RentalDto> allReturns  = new ArrayList<>();
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        //System.out.println(date);

        List<Rental> rentalByReturnDate = rentalRepo.findRentalByRentalDate(date);
        for (Rental r: rentalByReturnDate
        ) {
            allReturns.add(modelMapper.map(r, RentalDto.class));

        }
        return allReturns;
    }


    @Override
    public List<RentalDto> getAllRentalDateRental(){
        List<RentalDto> allRental  = new ArrayList<>();
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        //System.out.println(date);

        List<Rental> rentalByReturnDate = rentalRepo.findRentalByRentalDate(date);
        for (Rental r: rentalByReturnDate
        ) {
            allRental.add(modelMapper.map(r, RentalDto.class));

        }
        return allRental;

    }




}
