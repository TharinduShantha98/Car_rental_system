package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrdersDto;

import java.util.List;

public interface OrderService {

    boolean addOrder(OrdersDto ordersDto);
    OrdersDto searchOrder(String id);
    boolean updateOrder(OrdersDto ordersDto);
    boolean deleteOrder(OrdersDto ordersDto);
    List<OrdersDto> getAllOrder();


}
