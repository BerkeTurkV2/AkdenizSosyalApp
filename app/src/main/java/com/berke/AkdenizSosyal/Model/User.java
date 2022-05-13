package com.berke.AkdenizSosyal.Model;

public class User {
    private String UserName, userEmail, userPassword, userId;

    public User(String userName, String userEmail, String userPassword, String userId) {
        this.UserName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userId = userId;
    }
    public User(){

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
