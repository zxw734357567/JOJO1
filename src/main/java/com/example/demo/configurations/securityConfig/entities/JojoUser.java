package com.example.demo.configurations.securityConfig.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2019-4-24.
 */
@Entity
@Table(name = "jojo_user")
@ApiModel(description = "用户节点")
public class JojoUser {
    private Long id;
    @ApiModelProperty(value = "用户名", name = "username", required = false)
    private String username;
    @ApiModelProperty(value = "密码", name = "password", required = false)
    private String password;
    @ApiModelProperty(value = "父节点", name = "pid", required = false,example = "1")
    private Long pid;
    @ApiModelProperty(value = "路径", name = "path", required = false)
    private String path;

    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "pid")
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JojoUser jojoUser = (JojoUser) o;

        if (id != jojoUser.id) return false;
        if (username != null ? !username.equals(jojoUser.username) : jojoUser.username != null) return false;
        if (password != null ? !password.equals(jojoUser.password) : jojoUser.password != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "JojoUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }



}
