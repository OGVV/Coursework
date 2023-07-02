package com.example.site.models;

import jakarta.persistence.*;

@Entity
public class Students {

    @Id
    private long id;
    private String Fname;
    private String Lname;
    private String Email;
    private String Patrone;
    private String Faculty;
    private String Form;
    private String Special;
    private String Number;
    private String Adress;
    public Students(String fname, String lname, String patron, String email, String adress,String faculty,String form,String special,String number) {
        Fname=fname;
        Lname=lname;
        Patrone=patron;
        Email=email;
        Adress=adress;
        Faculty=faculty;
        Form=form;
        Special=special;
        Number=number;

    }
    public Students() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        this.Adress = adress;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getPatrone() {
        return Patrone;
    }

    public void setPatrone(String patrone) {
        Patrone = patrone;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String form) {
        Form = form;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
