package lk.ijse.spring.controller;


import lk.ijse.spring.dto.CarDto;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/car")
@CrossOrigin
public class CarController {





    public ResponseUtil saveCar(CarDto carDto){

        return  null;
        

    }


}
