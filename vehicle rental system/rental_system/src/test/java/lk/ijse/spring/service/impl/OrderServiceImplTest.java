package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    OrderDetailRepo orderDetailRepo;

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

    @Test
    void getOrderDetails(){
        List<OrderDetail> allOrderDetail =
                orderDetailRepo.getAllOrderDetail("O-100");

        List<OrderDetail> orderDetails = new ArrayList<>();


        for (OrderDetail o1:allOrderDetail
             ) {
            System.out.println(o1);
            System.out.println(o1.getCar());

            orderDetails.add(new OrderDetail(
                    o1.getOrderId(),o1.getCarId(),
                    o1.getRequiredDate(),o1.getReturnDate(),
                    o1.getPrice(),null,null));

        }
    }
}