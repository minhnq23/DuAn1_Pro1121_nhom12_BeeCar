package com.example.beecar.Model;

public class Driver {
    private   String idDriver;
    private String user_name;
    private String password;
    private String full_name;
    private String status_driver;
    private String idUser;

    public Driver() {
    }

    public Driver(String idDriver, String user_name, String password, String full_name, String status_driver, String idUser) {
        this.idDriver = idDriver;
        this.user_name = user_name;
        this.password = password;
        this.full_name = full_name;
        this.status_driver = status_driver;
        this.idUser = idUser;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getStatus_driver() {
        return status_driver;
    }

    public void setStatus_driver(String status_driver) {
        this.status_driver = status_driver;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
