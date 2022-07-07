package lk.ijse.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private String carId;
    private  String type;
    private int numberOfPassengers;
    private String transmissionType;
    private String color;
    private String registrationNum;
    private String priceForExrKM;
    private String freeMileage;
    private double MonthlyRate;
    private double DailyRate;






}
