package lk.ijse.spring.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@ToString
@Entity
@IdClass(OrderDetailPk.class)
public class OrderDetail {

    @Id
    private  String orderId;
    @Id
    private  String carId;

    private String requiredDate;
    private String returnDate;
    private double price;

    //@JsonBackReference(value = "Orders")
    //@Transient
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Orders Orders;


    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId", insertable = false, updatable = false)
    private Car car;


//    @Autowired
//    public OrderDetail(String orderId, String carId, String requiredDate, String returnDate, double price) {
//        this.orderId = orderId;
//        this.carId = carId;
//        this.requiredDate = requiredDate;
//        this.returnDate = returnDate;
//        this.price = price;
//    }
}
