package com.yutex.model.repositories;

import com.yutex.model.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Modifying
    @Transactional
    @Query("update Users  u set u.phoneNum=?1, u.passwordUser=?2, u.name=?3, u.login=?4  where u.id=?5")
    void update(@Param("phoneNum") String phoneNum,@Param("passwordUser") String passwordUser,@Param("name") String name,@Param("login") String login, @Param("id") Integer id);

}
