package com.example.demo.Dto;

import com.example.demo.configurations.securityConfig.entities.JojoUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserTree {
    private Long id;
    private String username;
    private String password;
    private Long pid;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTree userTree = (UserTree) o;
        return id == userTree.id &&
                pid == userTree.pid &&
                Objects.equals(username, userTree.username) &&
                Objects.equals(password, userTree.password) &&
                Objects.equals(path, userTree.path) &&
                Objects.equals(childNode, userTree.childNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, pid, path, childNode);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    private List<UserTree> childNode =new ArrayList<>();

    public List<UserTree> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<UserTree> childNode) {
        this.childNode = childNode;
    }
}
