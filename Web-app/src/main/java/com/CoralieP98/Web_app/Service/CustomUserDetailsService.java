package com.CoralieP98.Web_app.Service;


import com.CoralieP98.Web_app.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.CoralieP98.Web_app.Service.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class CustomUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUserName(String email) throws UsernameNotFoundException {
        User user = userService.findByUserName(email);
        if (user == null){
            return null;
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
