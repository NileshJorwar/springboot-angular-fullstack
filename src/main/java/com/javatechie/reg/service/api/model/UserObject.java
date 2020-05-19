package com.javatechie.reg.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="USER_REG_TBL")
public class UserObject {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String password;
    private String email;
    private int experience;
    private String domain;
}
