package com.yutex.controllers;

import com.yutex.model.entities.Client;
import com.yutex.model.entities.Product;
import com.yutex.model.entities.Users;
import com.yutex.model.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class ClientController {
    private  final ClientService clientService;
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read(){
        List<Client> clients = clientService.getAll();

        return !(clients == null || clients.isEmpty()) ?
                new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/clients", params = {"id"})
    public  ResponseEntity<Boolean> exist(@RequestParam(name = "id") int id){
        if (clientService.existById(id)) {

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
