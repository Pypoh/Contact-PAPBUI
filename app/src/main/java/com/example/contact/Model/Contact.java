package com.example.contact.Model;

import android.graphics.Bitmap;

public class Contact {

    private String name;
    private String email;
    private String gender;
    private String jabatan;
    private Bitmap gambar;

    public Contact() {
    }

    public Contact(String name, String email, String gender, String jabatan, Bitmap gambar) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.jabatan = jabatan;
        this.gambar = gambar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public Bitmap getGambar() {
        return gambar;
    }

    public void setGambar(Bitmap gambar) {
        this.gambar = gambar;
    }
}
