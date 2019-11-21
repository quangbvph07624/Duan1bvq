package com.example.duanbvq.model;

public class Bienbao {
    int id, image;
    String name;
    String mota;

    public Bienbao(int id, int image, String name, String mota) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.mota = mota;
    }

    public Bienbao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
