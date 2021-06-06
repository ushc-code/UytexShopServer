package com.yutex.model.repositories;

import com.yutex.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
    User findByPasswordAndEmail (String password,String email);
    User findByEmail(String email);
}
