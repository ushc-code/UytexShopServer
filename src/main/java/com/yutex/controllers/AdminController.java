package com.yutex.controllers;

import com.yutex.model.entities.Admin;
import com.yutex.model.entities.Client;
import com.yutex.model.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    @GetMapping(value = "/admins")
    public ResponseEntity<List<Admin>> read(){
        List<Admin> admins = adminService.getAll();

        return !(admins == null || admins.isEmpty()) ?
                new ResponseEntity<>(admins, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/admins", params = {"id"})
    public  ResponseEntity<Boolean> exist(@RequestParam(name = "id") int id){
        if (adminService.existById(id)) {

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
