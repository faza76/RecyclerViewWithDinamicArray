package com.example.recyclerv;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Faza Akbar on 21/03/19.
 * faza.akbar.tif17@polban.ac.id
 */
public class kendaraan implements Serializable {


    private  String name;
    private String desc;
    Drawable img;

    public kendaraan(String name, String desc,Drawable img) {
        this.desc = desc;
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}

