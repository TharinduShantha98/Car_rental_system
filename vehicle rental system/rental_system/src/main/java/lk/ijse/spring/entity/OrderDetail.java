package lk.ijse.spring.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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

    //@JsonBackReference(value = "Orders")
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Orders Orders;


    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId", insertable = false, updatable = false)
    private Car car;








}
