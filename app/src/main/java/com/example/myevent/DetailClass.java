package com.example.myevent;

public class DetailClass {
    private String pname, status, address, date, totalAmount;

    public DetailClass() {
    }

    public DetailClass(String pname, String status, String address, String date, String totalAmount) {
        this.pname = pname;
        this.status = status;
        this.address = address;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
