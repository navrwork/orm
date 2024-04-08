package com.navr.hibernatedemo.entity;

public class EmployeeAddress {

    private int empAddrId; // PK
    private int empId; // FK
    private String address;
    private String city;
    private String state;
    private String zip;

    public int getEmpAddrId() {
        return empAddrId;
    }

    public void setEmpAddrId(int empAddrId) {
        this.empAddrId = empAddrId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
