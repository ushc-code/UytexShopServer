package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name="id_user")
    @SequenceGenerator(name="usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usersIdSeq")
    private Integer id;

    @Column(name="phone_num")
    private  String phoneNum;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "name_user")
    private String name;

    @Column(name = "login")
    private String login;

}
