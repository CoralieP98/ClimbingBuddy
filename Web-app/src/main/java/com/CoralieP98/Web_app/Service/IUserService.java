package com.CoralieP98.Web_app.Service;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User register(User user);

    public User findByUserName(String email);
}