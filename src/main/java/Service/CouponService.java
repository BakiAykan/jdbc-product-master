package Service;

import com.proje.model.Coupon;
import com.proje.model.User;

import java.util.List;

public interface CouponService {

    Coupon saveCoupon(Coupon coupon);

    boolean couponUser(int couponId, int userId);

    Coupon updateCoupon(Coupon coupon);

    boolean removeCoupon(int couponId);

    Coupon findCouponById(int couponId);

    Coupon findCouponUsersById(int couponId);

    List<Coupon> findCoupons();

    int findCouponLastId();

    List<Coupon> findUser_Coupon(User user);
}
