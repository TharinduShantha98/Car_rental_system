package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class RentalDto {
    private String rentalId;
    private Date rentalDate;
    private Date returnDate;
    private double  totalPayment;

    private Driver driver;
    private Customer customer;
    private Car car;
    private Admin admin;





}
