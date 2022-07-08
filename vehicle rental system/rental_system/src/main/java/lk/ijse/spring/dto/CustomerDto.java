package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDto {

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
