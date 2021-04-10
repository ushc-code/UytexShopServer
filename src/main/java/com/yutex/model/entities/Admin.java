package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {
    @Id
    @Column(name="id_user")
    private Integer id;


}
