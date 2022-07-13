package lk.ijse.spring.controller;


import lk.ijse.spring.dto.RentalDto;
import lk.ijse.spring.service.RentalService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rental")
@CrossOrigin

public class RentalController {

    @Autowired
    RentalService rentalService;



    @PostMapping
    public ResponseUtil addRental(@RequestBody RentalDto rentalDto){
        boolean b = rentalService.addRental(rentalDto);
        return  new ResponseUtil(200, "successful rental Happy customer", b);



    }





}
