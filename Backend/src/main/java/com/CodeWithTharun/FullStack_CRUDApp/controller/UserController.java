package com.CodeWithTharun.FullStack_CRUDApp.controller;
import com.CodeWithTharun.FullStack_CRUDApp.exception.UserNotFoundException;
import com.CodeWithTharun.FullStack_CRUDApp.model.User;
import com.CodeWithTharun.FullStack_CRUDApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser , @PathVariable Long id){
        return userRepository.findById(id)
                .map(User ->{
                    User.setUsername(newUser.getUsername());
                    User.setName(newUser.getName());
                    User.setEmail(newUser.getEmail());
                    return userRepository.save(User);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" has been successfully deleted";
    }


}
