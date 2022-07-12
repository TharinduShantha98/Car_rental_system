package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Orders {

    @Id
    private String orderId;
    private String  requiredDate;
    private String returnDate;
    private String review;
    private double totalPrice;
    private String status;
    private String downPaymentClip;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="adminId", referencedColumnName = "adminId", nullable = false)
    private Admin admin;


    @OneToMany(mappedBy = "Orders", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

















}
