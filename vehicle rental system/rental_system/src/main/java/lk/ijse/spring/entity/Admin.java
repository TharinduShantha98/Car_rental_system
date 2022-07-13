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
public class Admin {

    @Id
   // @Column(columnDefinition = "varchar(255) default 'A-100'")
    private String adminId;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String contactNum;





}
