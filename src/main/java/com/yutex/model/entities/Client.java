package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Client")
public class Client {

    @Id
    @Column(name="id_user")
    private Integer id;
}
