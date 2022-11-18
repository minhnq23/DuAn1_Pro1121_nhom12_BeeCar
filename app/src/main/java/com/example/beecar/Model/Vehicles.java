package com.example.beecar.Model;

public class Vehicles {
    int id;
    int image;
    String name_car;
    int price_time;
    int price_date;
    int count_muon;
    String day_bd;
    int id_category;
    public  static final String TB_name = "tb_vehicles";
    public  static final String COL_id = "id";
    public  static final String COL_image_car = "image_car";
    public  static final String COL_name_car = "name_car";

    public  static final String COL_price_time = "price_time";
    public  static final String COL_price_date = "price_date";
    public  static final String COL_count_muon = "count_muon";
    public  static final String COL_day_bd = "day_bd";
    public  static final String COL_id_category = "id_category";

    public Vehicles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay_bd() {
        return day_bd;
    }

    public void setDay_bd(String day_bd) {
        this.day_bd = day_bd;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName_car() {
        return name_car;
    }

    public void setName_car(String name_car) {
        this.name_car = name_car;
    }

    public int getCount_muon() {
        return count_muon;
    }

    public void setCount_muon(int count_muon) {
        this.count_muon = count_muon;
    }

    public int getPrice_time() {
        return price_time;
    }

    public void setPrice_time(int price_time) {
        this.price_time = price_time;
    }

    public int getPrice_date() {
        return price_date;
    }

    public void setPrice_date(int price_date) {
        this.price_date = price_date;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
