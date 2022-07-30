package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.FileUploadUtil;
import lk.ijse.spring.util.ResponseUtil;
import lk.ijse.spring.util.ResponseUtilImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
    public ResponseUtil getCustomer() throws IOException {
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        List<ResponseUtilImage> responseUtilImages = new ArrayList<>();
        for (CustomerDto d1:allCustomer
             ) {
            String customerId = d1.getCustomerId();
            String licenseImg1 = d1.getLicenseImg1();
            String nicImg = d1.getNICImg();
            File file1 = new File("D:/fileServer/customer/"+customerId+"/"+licenseImg1);
            File file2 = new File("D:/fileServer/customer/"+customerId+"/"+nicImg);

            try {

                InputStreamResource resource = new InputStreamResource(new FileInputStream(file1));
                InputStream inputStream = resource.getInputStream();
                byte[] bytes1 = StreamUtils.copyToByteArray(inputStream);


                InputStreamResource resource2 = new InputStreamResource(new FileInputStream(file2));
                InputStream inputStream2 = resource2.getInputStream();
                byte[] bytes2 = StreamUtils.copyToByteArray(inputStream2);


                responseUtilImages.add(new ResponseUtilImage(d1,bytes1,bytes2));




            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }



        }

        return  new ResponseUtil(200,"success get all Customers", allCustomer);





       /* Path path = file.toPath();
        String mimeType = Files.probeContentType(path);
        System.out.println(mimeType);*/



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
            String uploadDir = "D:/fileServer/customer/"+ customerDto.getCustomerId();

            System.out.println(uploadDir);
            System.out.println(customerDto.getNICImg());
            System.out.println(customerDto.getLicenseImg1());


            FileUploadUtil.saveFile(uploadDir,storeImage);
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


    public ResponseUtil getAllImages(){
        return null;
    }


    @GetMapping(value = "lastCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseUtil getLastId(){
        String lastId = customerService.getLastId();
        return new ResponseUtil(200,"success get lastId", lastId);



    }



}
