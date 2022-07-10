package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(CustomerDto customerDto);




    List<CustomerDto> getAllCustomer();
}
