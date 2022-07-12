package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrdersDto {
    private String orderId;
   // @JsonFormat(pattern = "yyyy-MM-dd")
    private String requiredDate;
   // @JsonFormat(pattern = "yyyy-MM-dd")
    private String returnDate;
    private String review;
    private double totalPrice;
    private String status;
    private String downPaymentClip;
    private Customer customer;
    private Admin admin;
    private List<OrderDetail> orderDetails;

}
