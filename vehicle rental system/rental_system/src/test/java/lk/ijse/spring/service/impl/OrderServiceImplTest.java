package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith({SpringExtension.class})
class OrderServiceImplTest {


    @Autowired
    OrderRepo orderRepo;


    @Autowired
    ModelMapper modelMapper;

    @Test
    void addOrder() {
    }

    @Test
    void searchOrder() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void getAllOrder() {

        if(orderRepo.existsById("O-100")){
            Optional<Orders> byId = orderRepo.findById("O-100");
            System.out.println(byId.get());

        }







    }

    @Test
    void getSearchCustomer(){

        if(orderRepo.existsById("O-100")){
            String ordersByOrderId = orderRepo.getSearchCustomer("O-100");
            System.out.println(ordersByOrderId);



        }

    }
}