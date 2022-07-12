package lk.ijse.spring.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResponseUtilImage {

    Object result;
    byte[] image1;
    byte[] image2;



}
