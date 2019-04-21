package com.example.demo.entity;


import javax.persistence.*;

/**
 * Created by Administrator on 2019-4-11.
 */
@Entity
@Table(name = "rol_user")
public class User {
    @Id
    @Column(name = "id",length = 32)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name",length = 32)
    private String userName;
    @Column(name = "password",length = 32)
    private String password;
    @Column(name = "roleId",length = 32)
    private Long roleId;
    @Column(name = "address",length = 64)
    private String address;
    @Column(name = "roles",length = 64)
    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
