package com.CoralieP98.Web_app.Service;

import com.CoralieP98.Web_app.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private final PasswordEncoder passwordEncoder;
    private final ClimbFeignClient climbFeignClient;


    @Override
    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return climbFeignClient.createUser(user).getBody();
    }

    @Override
    public User findByUserName(String email){
        return climbFeignClient.getUserByUserName(email).getBody();
    }



}
