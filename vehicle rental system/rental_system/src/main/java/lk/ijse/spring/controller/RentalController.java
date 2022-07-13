package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.dto.RentalDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.RentalService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rental")
@CrossOrigin

public class RentalController {

    @Autowired
    RentalService rentalService;



    @PostMapping
    public ResponseUtil addRental(@RequestBody RentalDto rentalDto){
        CustomerDto customerDto = rentalDto.getCustomer();
        //System.out.println(customerDto);
        boolean b = rentalService.addRental(rentalDto);
        return  new ResponseUtil(200, "successful rental Happy customer", b);

    }

    @PutMapping
    public ResponseUtil updateRental(@RequestBody RentalDto rentalDto){
        boolean b = rentalService.updateRental(rentalDto);
        return new ResponseUtil(200,"successful update",b);

    }

    @DeleteMapping
    public ResponseUtil deleteRental(@RequestParam String id){
        boolean b = rentalService.deleteRental(id);
        return new ResponseUtil(200, "delete successful", b);

    }


    @GetMapping
    public  ResponseUtil getAllRental(){
        List<RentalDto> allRental = rentalService.getAllRental();
        return new ResponseUtil(200, "search  successful", allRental);

    }

    @GetMapping(value = "search")
    public  ResponseUtil searchRental(@RequestParam("id") String id){
        RentalDto rentalDto = rentalService.searchRental(id);
        return new ResponseUtil(200, "delete successful", rentalDto);


    }












}
