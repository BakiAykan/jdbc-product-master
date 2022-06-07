package Servicee.Impl;

import Service.CouponService;
import com.proje.model.Coupon;
import com.proje.model.User;
import com00proje.repository.Impl.CouponRepositoryImpl;
import com__proje.repository.CouponRepository;

import java.util.List;

public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository = new CouponRepositoryImpl();

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.saveCoupon(coupon);
    }

    @Override
    public boolean couponUser(int couponId, int userId) {return couponRepository.saveCouponUser(couponId,userId);}

    @Override
    public Coupon updateCoupon(Coupon coupon) {return couponRepository.updateCoupon(coupon);
    }

    @Override
    public boolean removeCoupon(int couponId) {
        return couponRepository.removeCoupon(couponId);
    }

    @Override
    public Coupon findCouponById(int couponId) {
        return couponRepository.findCouponById(couponId);
    }

    @Override
    public Coupon findCouponUsersById(int couponId) {
        return couponRepository.findCouponUsersById(couponId);
    }

    @Override
    public List<Coupon> findCoupons() {
        return couponRepository.findCoupons();
    }

    @Override
    public int findCouponLastId() {
        return couponRepository.findCouponLastId();
    }

    public List<Coupon> findUser_Coupon(User user){ return couponRepository.findUser_Coupon(user); }
}
