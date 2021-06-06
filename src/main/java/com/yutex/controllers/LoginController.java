package com.yutex.controllers;

import com.yutex.model.dto.UserDto;
import com.yutex.model.entities.User;
import com.yutex.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/auth")
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    /*@GetMapping(value = "" ,params = {"name"})
    public ResponseEntity<User> registerUser(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(userRepository.findByUsername(name), HttpStatus.OK);
    }*/

    @RequestMapping(value = "", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        if(userDto != null){
            if (userRepository.findByEmail(userDto.getEmail())!=null&& passwordEncoder.matches(userDto.getPassword(),userRepository.findByEmail(userDto.getEmail()).getPassword())/*userRepository.findByPasswordAndEmail(userDto.toUser(passwordEncoder).getPassword(), userDto.toUser(passwordEncoder).getEmail())*/) {
                return new ResponseEntity<>(userRepository.findByEmail(userDto.getEmail()),HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
