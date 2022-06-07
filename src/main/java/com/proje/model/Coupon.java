package com.proje.model;

import java.util.List;

public class Coupon {

    private int couponId;

    private String couponName;

    private double unitPrice;

    private List<User> users;

    public Coupon() {
    }

    public Coupon(int couponId, String couponName, double unitPrice) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.unitPrice = unitPrice;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<User> getUsers() {

        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", unitPrice=" + unitPrice +
                ", users=" + users +
                '}';
    }
}
