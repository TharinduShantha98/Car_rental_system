package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepo extends JpaRepository<Orders, String> {



    Orders findOrdersByOrderId(String id);

    @Query(value = "select status from  Orders  where orderId = ?1", nativeQuery = true )
    String getSearchCustomer(String orderId);

    @Query(value = "select requiredDate from  Orders  where orderId = ?1", nativeQuery = true )
    String getData(String orderId);

}
