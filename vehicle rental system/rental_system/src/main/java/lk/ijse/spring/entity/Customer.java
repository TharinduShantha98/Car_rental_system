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
@ToString
@Data
@Entity
public class Customer {
    @Id
   // @Column(columnDefinition = "varchar(255) default 'C-100'")
    private String customerId;
    private String firstName;
    private String address;
    private String email;
    private String NICNumber;
    private  String drivingLicNum;
    private String contactNum;
    private String password;
    private String licenseImg1;
    private String NICImg;














}
