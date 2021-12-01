package com.arif.carikos.Network;

import com.arif.carikos.Kost;

import java.util.List;

public class Responserver {
    private String respon;
    private int kode;
    private List<Kost> data;

    public String getRespon() {
        return respon;
    }

    public void setRespon(String respon) {
        this.respon = respon;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<Kost> getData() {
        return data;
    }

    public void setData(List<Kost> data) {
        this.data = data;
    }
}
