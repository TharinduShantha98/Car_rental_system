package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.OrdersDto;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.OrderDetailRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public boolean addOrder(OrdersDto ordersDto) {

        if(!orderRepo.existsById(ordersDto.getOrderId())){
            orderRepo.save(modelMapper.map(ordersDto, Orders.class));

            if (ordersDto.getOrderDetails().size()<1) {
                throw  new RuntimeException("no cars added for the order");
            }

            for (OrderDetail orderDetail: ordersDto.getOrderDetails()
                 ) {
                orderDetailRepo.save(orderDetail);
                return true;

            }
        }




        return false;
    }

    @Override
    public OrdersDto searchOrder(String id) {
        return null;
    }

    @Override
    public boolean updateOrder(OrdersDto ordersDto) {
        return false;
    }

    @Override
    public boolean deleteOrder(OrdersDto ordersDto) {
        return false;
    }

    @Override
    public List<OrdersDto> getAllOrder() {
        return null;
    }
}
