package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private LocalDate rentalDate;
    private LocalTime rentalTime;
    private LocalDate returnDate;



    @ManyToOne()
    @JoinColumn(name = "driverId", referencedColumnName = "driverId", insertable = false, nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name= "customerId", referencedColumnName = "customerId",insertable = false,nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "carId", referencedColumnName = "carId",insertable = false, nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name= "adminId", referencedColumnName = "adminId", insertable = false, nullable = false)
    private Admin admin;























}
