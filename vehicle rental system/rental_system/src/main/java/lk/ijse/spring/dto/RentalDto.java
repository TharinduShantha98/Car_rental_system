package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;

import java.time.LocalDate;
import java.time.LocalTime;

public class RentalDto {
    private String rentalId;
    private LocalDate rentalDate;
    private LocalTime rentalTime;
    private LocalDate returnDate;

    private Driver driver;
    private Customer customer;
    private Car car;
    private Admin admin;




}
