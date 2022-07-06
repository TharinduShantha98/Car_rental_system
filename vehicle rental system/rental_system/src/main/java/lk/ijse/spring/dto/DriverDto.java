package lk.ijse.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class DriverDto {
    private String driverId;
    private String firstName;
    private String lastName;
    private int age;
    private String contactNum;
    private  String licenseId;
}
