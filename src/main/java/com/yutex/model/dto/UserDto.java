package com.yutex.model.dto;

import com.yutex.model.entities.Role;
import com.yutex.model.entities.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(phone);
        user.setUsername(username);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        return user;
    }
    /*public User loginFormToUser(PasswordEncoder passwordEncoder){
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(phone);
        user.setUsername(username);
    }*/
}
