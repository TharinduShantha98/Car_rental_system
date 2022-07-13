package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    private Date requiredDate;
    private Date returnDate;
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


// @Transient
    //@JsonManagedReference
    @OneToMany(mappedBy = "Orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails;

















}
