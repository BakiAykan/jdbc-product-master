package com__proje.repository;

import com.proje.model.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    boolean saveUserProduct(int userId, int productId);

    User updateUser(User user);

    boolean removeUser(int id);

    User findUserById(int id);

    User findUserProductsById(int id);

    List<User> findUsers();
}
