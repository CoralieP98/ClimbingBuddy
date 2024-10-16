package com.CoralieP98.Climb.Service;

import com.CoralieP98.Climb.Model.User;
import com.CoralieP98.Climb.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public User findByUserName(String email){
        return userRepository.findUserByEmail(email).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(int id){
        return userRepository.findUserById(id).get();
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public User updateUser(int id, User user){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserByMail(String email) {
        userRepository.deleteUserByEmail(email).get();
    }
}
