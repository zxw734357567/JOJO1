package com.example.demo.Dto;

/**
 * Created by Administrator on 2019-4-25.
 */
public class RolesAndPermissionInUser {
    private long JojoUserId;
    private String username;
    private String password;
    private String url;
    private long JojoRoleId;

    @Override
    public String toString() {
        return "RolesAndPermissionInUser{" +
                "JojoUserId=" + JojoUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", JojoRoleId=" + JojoRoleId +
                '}';
    }

    public RolesAndPermissionInUser(long jojoUserId, String username, String password, String url, long jojoRoleId) {
        JojoUserId = jojoUserId;
        this.username = username;
        this.password = password;
        this.url = url;
        JojoRoleId = jojoRoleId;
    }

    public long getJojoUserId() {
        return JojoUserId;
    }

    public void setJojoUserId(long jojoUserId) {
        JojoUserId = jojoUserId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getJojoRoleId() {
        return JojoRoleId;
    }

    public void setJojoRoleId(long jojoRoleId) {
        JojoRoleId = jojoRoleId;
    }
}
