package com.yutex.model.services;

import com.yutex.model.entities.Admin;
import com.yutex.model.entities.Orders;
import com.yutex.model.entities.Product;
import com.yutex.model.repositories.AdminRepository;
import com.yutex.model.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.findAll();
    }
    public Boolean existById(Integer id) {
        return adminRepository.existsById(id);
    }
}
