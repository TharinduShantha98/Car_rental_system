package lk.ijse.spring.controller;


import lk.ijse.spring.dto.AdminDto;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseUtil saveAdmin(@RequestBody AdminDto adminDto){
        adminService.saveAdmin(adminDto);
        return  new ResponseUtil(200, "successful add admin", null);

    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmins(){
        List<AdminDto> allAdmin = adminService.getAllAdmin();
        return new ResponseUtil(200, "getAll admin success ", allAdmin);

    }


    @GetMapping(value = "search", params = "id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@RequestParam String id){
        AdminDto adminDto = adminService.searchAdmin(id);
        return new ResponseUtil(200, "search  admin success ", adminDto);

    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDto adminDto){
        adminService.updateAdmin(adminDto);
        return  new ResponseUtil(200, "update success ", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id){
        adminService.deleteAdmin(id);
        return  new ResponseUtil(200, "Delete success ", null);

    }

    @GetMapping(value = "lastAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getLastAdmin(){
        System.out.println("lastAdmin");
        String nextId = adminService.getLastAdmin();
        return  new ResponseUtil(200, "success ful last admin ", nextId);

    }







}
