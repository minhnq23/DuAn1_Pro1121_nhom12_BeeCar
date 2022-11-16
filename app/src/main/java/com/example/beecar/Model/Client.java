package com.example.beecar.Model;

public class Client {
    private String idCilent;
    private String user_name;
    private String password;
    private String full_name;
    private String idUser;

    public Client() {
    }

    public Client(String idCilent, String user_name, String password, String full_name, String idUser) {
        this.idCilent = idCilent;
        this.user_name = user_name;
        this.password = password;
        this.full_name = full_name;
        this.idUser = idUser;
    }

    public String getIdCilent() {
        return idCilent;
    }

    public void setIdCilent(String idCilent) {
        this.idCilent = idCilent;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
