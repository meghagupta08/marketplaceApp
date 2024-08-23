package com.example.marketplace.rest;

import com.example.marketplace.exception.UserNotFoundException;
import com.example.marketplace.model.User;
import com.example.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam Long userId) {
        Optional<User> user = userService.findUserById(userId);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else{
            throw new UserNotFoundException("User not found");
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User newUser){
        User user = userService.addUser(newUser);
        if(user!=null){
            return  new ResponseEntity<>("user added successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
