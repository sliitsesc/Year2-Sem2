package com.example.modelpaper;

import android.provider.BaseColumns;

public final class UserProfile {

    private int id;
    private String userName;
    private String dob;
    private String gender;
    private String password;

    public UserProfile() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    class Users implements BaseColumns {

        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_NAME_ID = "_ID";
        public static final String COLUMN_NAME_USERNAME = "_userName";
        public static final String COLUMN_NAME_PASSWORD = "_password";
        public static final String COLUMN_NAME_DATEOFBIRTH = "dateOfBirth";
        public static final String COLUMN_NAME_GENDER = "Gender";

    }
}