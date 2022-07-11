package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.FileUploadUtil;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("api/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;



    @PostMapping(value = "upload/image",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@ModelAttribute CarDto carDto,
                                @RequestParam("front")MultipartFile front,
                                @RequestParam("back") MultipartFile back,
                                @RequestParam("side")MultipartFile side,
                                @RequestParam("interior")MultipartFile interior) throws IOException {






        String frontFileName = StringUtils.cleanPath(Objects.requireNonNull(front.getOriginalFilename()));
        String backFileName = StringUtils.cleanPath(Objects.requireNonNull(back.getOriginalFilename()));
        String sideFileName = StringUtils.cleanPath(Objects.requireNonNull(side.getOriginalFilename()));
        String interiorFileName = StringUtils.cleanPath(Objects.requireNonNull(interior.getOriginalFilename()));

        HashMap<String, MultipartFile > storeImage = new HashMap<>();
        storeImage.put(frontFileName, front);
        storeImage.put(backFileName, back);
        storeImage.put(sideFileName, side);
        storeImage.put(interiorFileName, interior);

        carDto.setFrontView(frontFileName);
        carDto.setBackView(backFileName);
        carDto.setSideView(sideFileName);
        carDto.setInteriorView(interiorFileName);


        boolean result = carService.saveCar(carDto);

        if(result){
            String uploadDir = "D:/fileServer/car/"+carDto.getCarId();

            FileUploadUtil.saveFile(uploadDir,storeImage);
            return  new ResponseUtil(200, "car added success", null);

        }


        return  new ResponseUtil(200, "car added not success", null);

        

    }


}
