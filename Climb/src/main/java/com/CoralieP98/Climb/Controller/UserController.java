package com.CoralieP98.Climb.Controller;

import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Service.UserService;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }

    @PostMapping("findUserByUserName")
    public User getUserByUserName(@RequestParam String email){
        return userService.findByUserName(email);
    }

    @GetMapping("getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("findUserById")
    public User findUserById(@RequestParam int id){
        return userService.findUserById(id);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

    @PutMapping("updateUser")
    public User updateUser(@RequestParam(name = "id")int id, @RequestBody User user){
        return userService.updateUser(id,user);
    }
}
