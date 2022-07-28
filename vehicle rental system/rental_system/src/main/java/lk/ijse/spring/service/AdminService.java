package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDto;
import lk.ijse.spring.dto.DriverDto;
import lk.ijse.spring.entity.Admin;

import java.util.List;

public interface AdminService {

    void saveAdmin(AdminDto adminDto);
    AdminDto searchAdmin(String id);
    void deleteAdmin(String id);
    void updateAdmin(AdminDto adminDto);
    List<AdminDto> getAllAdmin();
    AdminDto getLastCustomer();


}
