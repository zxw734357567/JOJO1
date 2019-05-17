package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2019-4-24.
 */
@Entity
@Table(name = "jojo_role")
public class JojoRole {
    private long id;
    private String name;


    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
