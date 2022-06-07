package com00proje.repository.Impl;

import com.proje.model.*;
import com0proje.connection.DBCon;
import com__proje.repository.CouponRepository;
import com_proje.model.queries.CouponQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CouponRepositoryImpl implements CouponRepository {

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;


    @Override
    public Coupon saveCoupon(Coupon coupon) {

        connection = DBCon.getConnection();

        try {
            preparedStatement = connection.prepareStatement(CouponQuery.saveCouponQuery);
            preparedStatement.setInt(1,coupon.getCouponId());
            preparedStatement.setString(2, coupon.getCouponName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return coupon;
    }

    @Override
    public boolean saveCouponUser(int couponId, int userId) {
        connection = DBCon.getConnection();

        try {
            preparedStatement = connection.prepareStatement(CouponQuery.saveCoupon_UserQuery);
            preparedStatement.setInt(1,couponId);
            preparedStatement.setInt(2, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return true;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        connection = DBCon.getConnection();

        try {
            preparedStatement = connection.prepareStatement(CouponQuery.updateCouponQuery);
            preparedStatement.setString(1,coupon.getCouponName());
            preparedStatement.setInt(2,coupon.getCouponId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }

        return coupon;
    }

    @Override
    public boolean removeCoupon(int couponId) {
        connection = DBCon.getConnection();

        try {
            preparedStatement = connection.prepareStatement(CouponQuery.deleteCoupon_UserQuery);
            preparedStatement.setInt(1,couponId);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(CouponQuery.deleteCouponByIdQuery);
            preparedStatement.setInt(1,couponId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {

            DBCon.closeConnection(connection);
        }

        return true;
    }

    @Override
    public Coupon findCouponById(int couponId) {
        connection = DBCon.getConnection();
        Coupon coupon = null;
        try {
            preparedStatement = connection.prepareStatement(CouponQuery.findCouponByIdQuery);
            preparedStatement.setInt(1,couponId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                couponId = resultSet.getInt("couponId");
                String couponName = resultSet.getString("couponName");
                double unitPrice = resultSet.getDouble("unitPrice");

                coupon = new Coupon(couponId,couponName,unitPrice);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return coupon;
    }

    @Override
    public Coupon findCouponUsersById(int couponId) {
        connection = DBCon.getConnection();

        Coupon coupon = null;

        try {
            preparedStatement = connection.prepareStatement(CouponQuery.findCouponUsersByIdQuery);
            preparedStatement.setInt(1,couponId);
            resultSet = preparedStatement.executeQuery();

            boolean durum = true;
            List<User> users = new ArrayList<>();

            while (resultSet.next()){

                if (durum){

                    int couponIdd = resultSet.getInt("couponId");
                    String couponName = resultSet.getString("couponName");
                    double unitPrice = resultSet.getDouble("unitPrice");

                    coupon = new Coupon(couponIdd,couponName,unitPrice);
                    durum = false;
                }

                int userId = resultSet.getInt("userId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date birthOfDate = resultSet.getDate("birthOfDate");
                String userName = resultSet.getString("userName");

                User user = new User(userId,userName);

                users.add(user);
            }

            coupon.setUsers(users);

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBCon.closeConnection(connection);
        }

        return coupon;
    }

    @Override
    public int findCouponLastId() {
        connection = DBCon.getConnection();
        int i = 0;
        try {
            preparedStatement = connection.prepareStatement(CouponQuery.findLastCouponId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                i = resultSet.getInt("couponId");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return i;
    }

    @Override
    public List<Coupon> findCoupons() {
        connection = DBCon.getConnection();
        List<Coupon> coupons = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(CouponQuery.findCouponQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int couponIdd = resultSet.getInt("couponId");
                String couponName = resultSet.getString("couponName");
                double unitPrice = resultSet.getDouble("unitPrice");

                Coupon coupon = new Coupon(couponIdd,couponName,unitPrice);
                coupons.add(coupon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return coupons;
    }



    public List<Coupon> findUser_Coupon(User user){
        connection = DBCon.getConnection();
        List<Coupon> coupons = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(CouponQuery.findUser_CouponQuery);
            preparedStatement.setInt(1,user.getUserId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int couponIdd = resultSet.getInt("couponId");
                String couponName = resultSet.getString("couponName");
                double unitPrice = resultSet.getDouble("unitPrice");

                Coupon coupon = new Coupon(couponIdd,couponName,unitPrice);
                coupons.add(coupon);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            DBCon.closeConnection(connection);
        }
        return coupons;
    }


}
