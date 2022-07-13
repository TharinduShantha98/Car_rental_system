package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepo extends JpaRepository<Orders, String> {



    Orders findOrdersByOrderId(String id);

    @Query(value = "select * from  Orders  where orderId = ?1", nativeQuery = true )
    Orders getSearchCustomer(String orderId);




}
