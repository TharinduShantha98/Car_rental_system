package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Orders {

    @Id
    private String orderId;
    private LocalDate  requiredDate;
    private LocalDate returnDate;
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
















}
