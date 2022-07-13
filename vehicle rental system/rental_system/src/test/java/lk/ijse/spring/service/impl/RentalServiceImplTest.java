package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Rental;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.repo.RentalRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith({SpringExtension.class})
class RentalServiceImplTest {


    @Autowired
    RentalRepo rentalRepo;

    @Autowired
    ModelMapper modelMapper;


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;





    @Test
    void addRental() {

       /* String data = orderRepo.getData("O-100");
        System.out.println(data);

        System.out.println("==================");
        String[] str =  data.split(" ", 2);
        for (String a: str){
            System.out.println(a);

        }

        System.out.println("==================");


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String date = str[0];

        String format = dtf.format(now);

        if(date.equals(format)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }




        System.out.println(dtf.format(now));*/

//        List<OrderDetail> all = orderDetailRepo.findAll();
//        for (OrderDetail o1:all
//             ) {
//            System.out.println(o1);
//        }


        long l = System.currentTimeMillis();


        Date date = new Date(l);
        System.out.println(date);

        List<Rental> rentalByReturnDate = rentalRepo.findRentalByReturnDate(date);
        for (Rental r: rentalByReturnDate
             ) {
            System.out.println(r);

        }


    }

    @Test
    void getLastId() {
        Rental topByOrderByIdDesc = rentalRepo.findTopByOrderByRentalIdDesc();
        System.out.println(topByOrderByIdDesc);


    }





}