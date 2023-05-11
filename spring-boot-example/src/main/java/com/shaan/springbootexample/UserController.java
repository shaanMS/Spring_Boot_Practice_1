package com.shaan.springbootexample;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("api/customer")
public class UserController {
    private UserService usr;
    @PostMapping
    public ResponseEntity<Customer> createUser(@RequestBody Customer cus)
    {
    Customer savedCust=usr.createUser(cus);
    return new ResponseEntity<>(savedCust, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable("id") Long userId){
        Customer user = usr.getUserById(Math.toIntExact(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
