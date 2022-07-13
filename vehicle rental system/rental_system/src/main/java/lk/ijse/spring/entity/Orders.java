package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name="customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name="adminId", referencedColumnName = "adminId", nullable = false)
    private Admin admin;


    //@Transient
    @OneToMany(mappedBy = "Orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails;

















}
