package com.example.projectuas.user;

public class UserItem {
    String userID;
    String username;
    String userEmail;
    String Age;
    String Gender;
    String userCountry;


    public UserItem(String userID, String username, String userEmail,String Gender,String Age, String userCountry) {
        this.userID = userID;
        this.username = username;
        this.userEmail = userEmail;
        this.userCountry = userCountry;
        this.Gender=Gender;
        this.Age=Age;

    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public UserItem() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }}


