package com.example.gk_ao_06;

import java.io.Serializable;

public class Ao implements Serializable {
    private String tvName_01;
    private int tvGia_01;
    private int imageView_01;
    private int soLuong;

    private String size;

    public String getTvName_01() {
        return tvName_01;
    }

    public void setTvName_01(String tvName_01) {
        this.tvName_01 = tvName_01;
    }

    public int getTvGia_01() {
        return tvGia_01;
    }

    public void setTvGia_01(int tvGia_01) {
        this.tvGia_01 = tvGia_01;
    }

    public int getImageView_01() {
        return imageView_01;
    }

    public void setImageView_01(int imageView_01) {
        this.imageView_01 = imageView_01;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Ao(String tvName_01, int tvGia_01, int imageView_01, int soLuong, String size) {
        this.tvName_01 = tvName_01;
        this.tvGia_01 = tvGia_01;
        this.imageView_01 = imageView_01;
        this.soLuong = soLuong;
        this.size = size;
    }
}
