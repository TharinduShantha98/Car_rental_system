package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.CustomerFileUploadUtil;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/customer")
@CrossOrigin

public class CustomerController {


    @Autowired
    CustomerService customerService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCustomer(HttpServletResponse response) throws IOException {
        List<CustomerDto> allCustomer = customerService.getAllCustomer();

        File file = new File("D:/assets/customer/C-100/image1.jpg");
        Path path = file.toPath();
        String mimeType = Files.probeContentType(path);
        System.out.println(mimeType);
        try {

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            InputStream inputStream = resource.getInputStream();
            byte[] bytes = StreamUtils.copyToByteArray(inputStream);
            return new ResponseUtil(200, "get all success of customer detail",allCustomer );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

      return null;

    }



    @PostMapping(value = "upload/image",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute  CustomerDto customerDto ,
                                     @RequestParam("image2") MultipartFile license,
                                     @RequestParam("image3") MultipartFile NICImage) throws IOException {

       // System.out.println("hello");

//        System.out.println(customerDto.toString());
//        System.out.println(license);
//        System.out.println(NICImage);

        String licenseFileName = StringUtils.cleanPath(Objects.requireNonNull(license.getOriginalFilename()));
        String NICFileName = StringUtils.cleanPath(Objects.requireNonNull(NICImage.getOriginalFilename()));

        ArrayList<String> images = new ArrayList<>();
        images.add(licenseFileName);
        images.add(NICFileName);


        HashMap<String, MultipartFile> storeImage =  new HashMap<>();
        storeImage.put(licenseFileName, license);
        storeImage.put(NICFileName, NICImage);


        customerDto.setLicenseImg1(licenseFileName);
        customerDto.setNICImg(NICFileName);

        boolean result = customerService.saveCustomer(customerDto);

        if(result){
            String uploadDir = "D:/assets/customer/"+ customerDto.getCustomerId();

            System.out.println(uploadDir);
            System.out.println(customerDto.getNICImg());
            System.out.println(customerDto.getLicenseImg1());


            CustomerFileUploadUtil.saveFile(uploadDir,storeImage);
        }

        return  new ResponseUtil(200,"customer save success",null);

    }




    @GetMapping(value = "search", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@RequestParam String id){
        CustomerDto customerDto = customerService.searchCustomer(id);
        return new ResponseUtil(200, "search customer success", customerDto);


    }

    @PutMapping()
    public ResponseUtil updateCustomer(@RequestBody CustomerDto customerDto){
        boolean b = customerService.updateCustomer(customerDto);
        return new ResponseUtil(200, "customer update success", b);

    }

    @DeleteMapping()
    public ResponseUtil deleteCustomer(@RequestParam  String id){
        boolean b = customerService.deleteCustomer(id);
        return new ResponseUtil(200, "customer delete success", b);
    }

}
