package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
   // @Column(columnDefinition = "varchar(255) default 'CA-100'")
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
