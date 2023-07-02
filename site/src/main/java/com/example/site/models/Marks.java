package com.example.site.models;


import jakarta.persistence.*;

@Entity
public class Marks {

    @Id
    private long id;
    private String Math;
    private String Phisycs;
    private String Economics;
    private String Oop;
    private String Politics;
    private String Webdevelop;
    private String Russian;
    public Marks() {
    }
    public Marks(String math, String phisycs, String economics, String oop, String politics, String webdevelop, String russian,long Id) {
        Math = math;
        Phisycs=phisycs;
        Economics=economics;
        Oop=oop;
        Politics=politics;
        Webdevelop=webdevelop;
        Russian=russian;
        id=Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMath() {
        return Math;
    }

    public void setMath(String math) {
        Math = math;
    }

    public String getPhisycs() {
        return Phisycs;
    }

    public void setPhisycs(String phisycs) {
        Phisycs = phisycs;
    }

    public String getEconomics() {
        return Economics;
    }

    public void setEconomics(String economics) {
        Economics = economics;
    }

    public String getOop() {
        return Oop;
    }

    public void setOop(String oop) {
        Oop = oop;
    }

    public String getPolitics() {
        return Politics;
    }

    public void setPolitics(String politics) {
        Politics = politics;
    }

    public String getWebdevelop() {
        return Webdevelop;
    }

    public void setWebdevelop(String webdevelop) {
        Webdevelop = webdevelop;
    }

    public String getRussian() {
        return Russian;
    }

    public void setRussian(String russian) {
        Russian = russian;
    }
}

