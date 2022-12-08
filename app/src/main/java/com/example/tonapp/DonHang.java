package com.example.tonapp;

import java.text.SimpleDateFormat;

public class DonHang {
    private int orderId;
    private String orderCode;
    private int adminId;
    private long timeIn;
    private long timeOut;
    private long total;

    public DonHang(int orderId, int adminId, String orderCode, long timeIn, long timeOut, long total) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.adminId = adminId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.total = total;
    }



    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm dd/MM/yy");

        return "Biển số xe: " +orderCode +"\n" + "Giờ vào: "+ sdf.format(timeIn);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public long getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(long timeIn) {
        this.timeIn = timeIn;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
