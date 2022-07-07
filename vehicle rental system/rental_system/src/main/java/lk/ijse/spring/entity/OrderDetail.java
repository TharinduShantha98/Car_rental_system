package lk.ijse.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
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

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Orders Orders;


    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId", insertable = false, updatable = false)
    private Car car;








}
