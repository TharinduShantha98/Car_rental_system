package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDto;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveAdmin(AdminDto adminDto) {

        if(!adminRepo.existsById(adminDto.getAdminId())){
            adminRepo.save(modelMapper.map(adminDto, Admin.class));

        }else{
            throw new RuntimeException("this admin Id already exits");
        }


    }

    @Override
    public AdminDto searchAdmin(String id) {
        if(adminRepo.existsById(id)){
            Optional<Admin> byId = adminRepo.findById(id);
            return  modelMapper.map(byId.get(),AdminDto.class);
        }else{

            return  null;
        }



    }

    @Override
    public void deleteAdmin(String id) {

        if(adminRepo.existsById(id)){
            adminRepo.deleteById(id);

        }else {
            throw  new RuntimeException("this customer not found ");
        }

    }

    @Override
    public void updateAdmin(AdminDto adminDto) {
        if(adminRepo.existsById(adminDto.getAdminId())){
            adminRepo.save(modelMapper.map(adminDto,Admin.class));

        }else{
            throw  new RuntimeException("this customer not found for update");

        }

    }

    @Override
    public List<AdminDto> getAllAdmin() {

        List<Admin> all = adminRepo.findAll();
        List<AdminDto> allAdmins = new ArrayList<>();


        for (Admin a: all
             ) {
                allAdmins.add(modelMapper.map(a, AdminDto.class));
        }

        return allAdmins;
    }

    @Override
    public String getLastAdmin() {
        Admin topByOrderByAdminIdDesc = adminRepo.findTopByOrderByAdminIdDesc();
        String adminId = topByOrderByAdminIdDesc.getAdminId();

        if (topByOrderByAdminIdDesc != null) {

            int tempId = Integer.parseInt(adminId.split("-")[1]);
            tempId = tempId +1;
            return  "A-" + tempId;

        }else{
            return "A-100";
        }




        //return modelMapper.map(topByOrderByAdminIdDesc,AdminDto.class);

    }
}
