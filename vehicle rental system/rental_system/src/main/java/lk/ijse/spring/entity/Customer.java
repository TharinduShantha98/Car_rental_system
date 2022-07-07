package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String address;
    private String email;
    private String NICNumber;
    private  String drivingLicNum;
    private String contactNum;
    private String password;







}
