package com.example.myapplication;

public class User {
    private String Mobile;
    private String email;
    private String username;
    private String password;



    public User(String Mobile, String email, String username,String password) {
            this.Mobile = Mobile;
        this.email = email;
        this.password=password;
        this.username = username;

    }

    public User()
    {

    }



    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        Mobile = Mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
