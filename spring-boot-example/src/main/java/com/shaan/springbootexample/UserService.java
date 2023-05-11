package com.shaan.springbootexample;

import java.util.List;

public interface UserService {
    Customer createUser(Customer user);

    Customer getUserById(Integer userId);

    List<Customer> getAllUsers();

    Customer updateUser(Customer user);

    void deleteUser(Long userId);
}
