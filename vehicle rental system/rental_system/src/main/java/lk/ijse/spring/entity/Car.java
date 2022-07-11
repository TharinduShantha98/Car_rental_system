package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
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
    private String frontView;
    private String backView;
    private String sideView;
    private String interiorView;






}
