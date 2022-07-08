package lk.ijse.spring.controller;


import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("api/customer")
@CrossOrigin

public class CustomerController {


    @GetMapping
    public void getCustomer(){
        System.out.println("spring project create");
    }



    @PostMapping(params = {"license","NICImage"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(Customer customer ,
                                     @RequestParam MultipartFile license,
                                     @RequestParam MultipartFile NICImage){



            return null;
    }


}
