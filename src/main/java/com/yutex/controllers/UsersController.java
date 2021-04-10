package com.yutex.controllers;

import com.yutex.model.entities.Product;
import com.yutex.model.entities.Users;
import com.yutex.model.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @RequestMapping(value = "/users", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestBody Users users) {
        if(users != null){
            usersService.save(users);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<Users>> read(){
        List<Users> users = usersService.getAll();

        return !(users == null || users.isEmpty()) ?
                new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/users", params = {"id"})
    public ResponseEntity<Users> read(@RequestParam(name = "id") int id){
        Users users = usersService.getById(id);

        return users != null ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/users", params = {"id"} )
    public ResponseEntity<Void> delete(@RequestParam(name = "id") int id) {
       Users users = usersService.getById(id);
        if (usersService.exist(users)) {
            usersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @RequestMapping(value = "/users",params = {"id"},method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> update(@RequestBody Users users, @RequestParam(name = "id") int id) {

        if(users != null){
            usersService.updateById(users.getPhoneNum(),users.getPasswordUser(), users.getName(),users.getLogin(), id );
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
