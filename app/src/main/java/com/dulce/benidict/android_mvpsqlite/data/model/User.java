package com.dulce.benidict.android_mvpsqlite.data.model;

/**
 * Created by benidict on 02/09/2017.
 */

public class User {

    private int user_id;
    private String user_fname;
    private String user_lname;
    private String user_address;
    private String user_phone;
    private String user_email;
    private String user_password;

    public User(){

    }

    public User(int id, String fname, String lname, String address,
                String phone, String email, String pass){
        this.user_id = id;
        this.user_fname = fname;
        this.user_lname = lname;
        this.user_address = address;
        this.user_phone = phone;
        this.user_email = email;
        this.user_password = pass;
    }

    public User(String fname, String lname, String address,
                String phone, String email, String pass){

        this.user_fname = fname;
        this.user_lname = lname;
        this.user_address = address;
        this.user_phone = phone;
        this.user_email = email;
        this.user_password = pass;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_address() {
        return user_address;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
