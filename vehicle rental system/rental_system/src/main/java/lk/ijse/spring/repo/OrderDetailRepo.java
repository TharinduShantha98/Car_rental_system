package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {


    @Query(value= "select * from orderdetail where orderId = ?",  nativeQuery = true )
    List<OrderDetail> getAllOrderDetail(String name);


}
