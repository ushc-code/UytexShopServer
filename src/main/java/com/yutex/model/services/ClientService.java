package com.yutex.model.services;

import com.yutex.model.entities.Client;
import com.yutex.model.entities.Orders;
import com.yutex.model.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private  final ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    public Boolean existById(Integer id){
        return clientRepository.existsById(id);
    }
}
