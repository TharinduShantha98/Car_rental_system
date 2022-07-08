package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDto;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;


    @Override
    public void saveAdmin(AdminDto adminDto) {

    }

    @Override
    public AdminDto searchAdmin(String id) {
        return null;
    }

    @Override
    public void deleteAdmin(String id) {

    }

    @Override
    public void updateAdmin(AdminDto adminDto) {

    }

    @Override
    public List<AdminDto> getAllAdmin() {
        return null;
    }
}
