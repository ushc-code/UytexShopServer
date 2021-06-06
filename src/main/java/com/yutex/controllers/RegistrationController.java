package com.yutex.controllers;

import com.yutex.model.dto.UserDto;
import com.yutex.model.entities.Product;
import com.yutex.model.entities.User;
import com.yutex.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/registration")
@RestController
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "" ,params = {"name"})
    public ResponseEntity<User> registerUser(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(userRepository.findByUsername(name), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestBody UserDto userDto) {
        if(userDto != null){
            userRepository.save(userDto.toUser(passwordEncoder));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
