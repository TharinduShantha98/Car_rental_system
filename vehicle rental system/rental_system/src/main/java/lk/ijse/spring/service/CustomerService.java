package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

    boolean saveCustomer(CustomerDto customerDto);
    boolean updateCustomer(CustomerDto customerDto);
    boolean deleteCustomer(String id);
    CustomerDto searchCustomer(String id);
    List<CustomerDto> getAllCustomer();
    String getLastId();
    CustomerDto getCustomerLogin(String email, String password);


}
