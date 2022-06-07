package com__proje.repository;

import com.proje.model.Coupon;
import com.proje.model.User;

import java.util.List;

public interface CouponRepository {

    Coupon saveCoupon(Coupon coupon);

    boolean saveCouponUser(int couponId, int userId);

    Coupon updateCoupon(Coupon coupon);

    boolean removeCoupon(int couponId);

    Coupon findCouponById(int couponId);

    Coupon findCouponUsersById(int couponId);

    List<Coupon> findCoupons();

    int findCouponLastId();

    List<Coupon> findUser_Coupon(User user);
}
