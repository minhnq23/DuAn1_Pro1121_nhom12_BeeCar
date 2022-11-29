package com.example.beecar.Model;

public class Schedule {
    int id;
    String start_time;
    String end_time;
    String dia_diem;
    int driver_id;
    int receipt_id;
    public Schedule() {
    }

    public String getDia_diem() {
        return dia_diem;
    }

    public void setDia_diem(String dia_diem) {
        this.dia_diem = dia_diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }
}
