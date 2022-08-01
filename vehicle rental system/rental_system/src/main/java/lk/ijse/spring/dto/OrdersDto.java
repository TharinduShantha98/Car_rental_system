package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.OrderDetail;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrdersDto {
    private String orderId;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date requiredDate;

    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    private Date returnDate;

    private String review;
    private double totalPrice;
    private String status;
    private String downPaymentClip;
    private Customer customer;
    private Admin admin;


    private List<OrderDetail> orderDetails;

}
