package com.CoralieP98.Climb;

import com.CoralieP98.Climb.Controller.UserController;
import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Repository.PlaceRepository;
import com.CoralieP98.Climb.Repository.SessionRepository;
import com.CoralieP98.Climb.Repository.UserRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void createUser() {
        User newUser = new User(0,"meh","m","meh@meh.m");
        userController.createUser(newUser);
        assertThat(userController
                .getUserByUserName("meh@meh.m") != null).isEqualTo(true);
    }

    @Test
    public void getUser() {
        User user = new User(0,"pwet","p","pwet@p.p");
        userController.createUser(user);
        User fetchedUser = userController.findUserById(user.getId());
        assertThat(user.getId()).isEqualTo(fetchedUser.getId());
    }

    @Test
    public void getAllUsers() {
        assertThat(userController.getAllUsers().size()).isNotNull();
    }

    @Test
    public void UpdateUser() {
        User user = userController.getUserByUserName("meh@meh.m");
        user.setUserName("mehrde");
        userController.updateUser(user.getId(),user);
        User updatedUser = userController.findUserById(user.getId());
        assertThat(updatedUser.getUserName()).isEqualTo("mehrde");
    }

    @Test
    public void deleteUser() {
        List<User> users = userController.getAllUsers();
        int sizeStart = users.size();

        User user = userController.getUserByUserName("meh@meh.m");
        userController.deleteUser(user.getId());
        User user2 = userController.getUserByUserName("pwet@p.p");
        userController.deleteUser(user2.getId());

        List<User> usersAfter = userController.getAllUsers();
        int sizeEnd = usersAfter.size();
        assertThat(sizeStart).isGreaterThan(sizeEnd);

    }

}
