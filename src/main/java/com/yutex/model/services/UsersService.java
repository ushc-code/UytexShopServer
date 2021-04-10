package com.yutex.model.services;

import com.yutex.model.entities.Users;
import com.yutex.model.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;


    public void  save(Users users){
        usersRepository.save(users);
    }
    public List<Users> getAll(){
       return usersRepository.findAll();
    }
    public  Users getById(Integer id){
        return usersRepository.findById(id).isPresent() ? usersRepository.findById(id).get() : null;
    }
    public  void deleteById(Integer id){
        usersRepository.deleteById(id);
    }
    public  Boolean exist(Users users){
        return users !=null && usersRepository.exists(Example.of(users));
    }
    public void updateById( String phoneNum, String passwordUser, String name, String login, Integer id){

        usersRepository.update(phoneNum, passwordUser,name,login,id);


    }
}
