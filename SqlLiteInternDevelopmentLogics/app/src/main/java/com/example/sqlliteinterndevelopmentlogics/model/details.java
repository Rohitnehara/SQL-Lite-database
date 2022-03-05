package com.example.sqlliteinterndevelopmentlogics.model;

public class details {
    String UserName,Email;

    public details(String userName, String email) {
        UserName = userName;
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
