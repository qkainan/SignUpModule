package com.qkainan.domain;

public class User {

    private int id;
    private String username;
    private String password;
    private String hobby;


    public User() {
    }

    public User(int id, String username, String password, String hobby) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", hobby = " + hobby + "}";
    }
}
