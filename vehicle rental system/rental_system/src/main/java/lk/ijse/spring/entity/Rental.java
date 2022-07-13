package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Rental {
    @Id
    private String rentalId;
    private Date rentalDate;
    private Date returnDate;


    private double totalPayment;




    @ManyToOne()
    @JoinColumn(name = "driverId", referencedColumnName = "driverId")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name= "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "carId", referencedColumnName = "carId")
    private Car car;

    //@Transient
    @ManyToOne
    @JoinColumn(name= "adminId", referencedColumnName = "adminId")
    private Admin admin;


























}
