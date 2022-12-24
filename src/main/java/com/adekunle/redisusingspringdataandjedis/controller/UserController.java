package com.adekunle.redisusingspringdataandjedis.controller;

import com.adekunle.redisusingspringdataandjedis.model.Users;
import com.adekunle.redisusingspringdataandjedis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("creat")
    public ResponseEntity<String> createUser(@RequestBody Users user){
        boolean result = userService.createUser(user);
       if(result) return ResponseEntity.ok("User created successfully");
       else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
        Users user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId){
        boolean result = userService.deleteUserById(userId);
        if(result) return ResponseEntity.ok("User removed Successfully!!");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updatedUser(@PathVariable("userId") Long userId,@RequestBody Users user){
        boolean result = userService.updateUser(userId,user);
        if(result) return ResponseEntity.ok("User updated successfully");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
