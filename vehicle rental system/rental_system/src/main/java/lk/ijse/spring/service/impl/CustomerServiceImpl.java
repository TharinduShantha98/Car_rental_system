package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDto;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public boolean saveCustomer(CustomerDto customerDto) {
        System.out.println(customerDto);

        if(!customerRepo.existsById(customerDto.getCustomerId())){
            customerRepo.save(modelMapper.map(customerDto, Customer.class));
            return  true;


        }else {
            throw new RuntimeException("this customer is already exists " + customerDto.getCustomerId());

        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerDto> getAllCustomers  = new ArrayList<>();


        List<Customer> all = customerRepo.findAll();


        for (Customer c1 : all
             ) {
            getAllCustomers.add(modelMapper.map(c1,CustomerDto.class));
        }
        return getAllCustomers;


    }


}
