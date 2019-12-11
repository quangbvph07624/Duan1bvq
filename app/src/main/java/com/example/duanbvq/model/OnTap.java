package com.example.duanbvq.model;

public class OnTap {
    public  int id;
    public  String title;

    public OnTap(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public OnTap() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
