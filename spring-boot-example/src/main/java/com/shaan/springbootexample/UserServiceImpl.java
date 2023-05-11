package com.shaan.springbootexample;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    @Override
    public Customer createUser(Customer user) {
        return userRepo.save(user);
    }

    @Override
    public Customer getUserById(Integer userId) {
       Optional<Customer> optionalUser=userRepo.findById(Long.valueOf(userId));
       return optionalUser.get();
    }

    @Override
    public List<Customer> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Customer updateUser(Customer user) {
       Customer existingCustomer=userRepo.findById(Long.valueOf(user.getId())).get();
        existingCustomer.setName(user.getName());
        existingCustomer.setEmail(user.getEmail());
        existingCustomer.setId(Math.toIntExact(user.getId()));
        existingCustomer.setAge(user.getAge());
        Customer updateCustomer=userRepo.save(existingCustomer);
        return updateCustomer;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }




}
