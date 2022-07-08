package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.CustomerFileUploadUtil;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("api/customer")
@CrossOrigin

public class CustomerController {


    @Autowired
    CustomerService customerService;



    @GetMapping
    public void getCustomer(){
        System.out.println("spring project create");
    }



    @PostMapping(value = "upload/image",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute  CustomerDto customerDto ,
                                     @RequestParam("image2") MultipartFile license,
                                     @RequestParam("image3") MultipartFile NICImage) throws IOException {

        System.out.println("hello");

        System.out.println(customerDto.toString());
        System.out.println(license);
        System.out.println(NICImage);




        String licenseFileName = StringUtils.cleanPath(Objects.requireNonNull(license.getOriginalFilename()));
        String NICFileName = StringUtils.cleanPath(Objects.requireNonNull(NICImage.getOriginalFilename()));


        customerDto.setLicenseImg1(licenseFileName);
        customerDto.setNICImg(NICFileName);

        customerService.saveCustomer(customerDto);

        String uploadDir = "assets/"+ customerDto.getCustomerId();

        System.out.println(uploadDir);
        System.out.println(customerDto.getNICImg());
        System.out.println(customerDto.getLicenseImg1());
        CustomerFileUploadUtil.saveFile(uploadDir,licenseFileName,license);


        return null;
    }


}
