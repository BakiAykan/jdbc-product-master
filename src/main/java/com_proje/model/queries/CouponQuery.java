package com_proje.model.queries;

public class CouponQuery {

    public static final String saveCouponQuery = "INSERT INTO coupon(couponId, couponName) VALUES(?,?)";

    public static final String saveCoupon_UserQuery = "INSERT INTO coupon_user(couponId, userId) VALUES(?,?)";

    public static final String updateCouponQuery = "UPDATE coupon SET couponName=?  WHERE couponId =? ";

    public static final String deleteCoupon_UserQuery = "DELETE FROM coupon_user WHERE couponId =? ";
    public static final String deleteCouponByIdQuery = "DELETE FROM coupon couponId =? ";

    public static final String findCouponByIdQuery = "SELECT * FROM coupon WHERE couponId =? ";

    public static final String findCouponQuery = "SELECT * FROM coupon";

    public static final String findCouponUsersByIdQuery = "SELECT * FROM coupon c LEFT OUTER JOIN coupon_user cu ON(c.couponId = cu.couponId) " +
            "LEFT JOIN user u ON(cu.userId = u.userId)  WHERE c.couponId=?";

    public static final String findLastCouponId = "select * FROM coupon ORDER By couponId desc limit 1";

    public static final String findUser_CouponQuery ="SELECT * FROM user u LEFT OUTER JOIN user_coupon uc ON(u.userId = uc.userId ) " +
                                                     "LEFT JOIN coupon c ON(uc.couponId = c.couponId) WHERE u.userId= ?";
}
