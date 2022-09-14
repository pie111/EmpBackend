package com.example.crudoperations.model;
import com.example.crudoperations.controller.EmpController;
import org.springframework.web.bind.annotation.CrossOrigin;


public class EmpDataModel {
    private float id;
    private String fname;
    private String lname;
    private String tel;
    private String address;
    private String city;
    private String state;
    private float zip;
//
    public EmpDataModel(float id, String fname, String lname, String tel, String address, String city, String state, float zip) {
        this.id =id;
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.address =address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public EmpDataModel(String fname, String lname, String tel, String address, String city, String state, float zip) {
        this.fname = fname;
        this.lname = lname;
        this.tel = tel;
        this.address =address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    public EmpDataModel(){

    }


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public float getZip() {
        return zip;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(float zip) {
        this.zip = zip;
    }
    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", First Name=" + fname +", Last Name="+lname+ ", tel=" + tel+", Address=" + address + ", City=" + city + ", State=" + state + ", Zip=" + zip+"]";
    }
}