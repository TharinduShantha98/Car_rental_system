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
public class Driver {

    @Id
    @Column(columnDefinition = "varchar(255) default 'D-102'")
    private String driverId;
    private String firstName;
    private String lastName;
    private int age;
    private String contactNum;
    private  String licenseId;
    private String status;







}
