package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AdminDto {
    private String adminId;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String contactNum;

}
