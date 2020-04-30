package com.example.myevent;

public class Orders {

    String address, date, pending, pname, status, time, totalAmount;

    public Orders(String address, String date, String pending, String pname, String status, String time, String totalAmount) {
        this.address = address;
        this.date = date;
        this.pending = pending;
        this.pname = pname;
        this.status = status;
        this.time = time;
        this.totalAmount = totalAmount;
    }


    public Orders() {
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

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
