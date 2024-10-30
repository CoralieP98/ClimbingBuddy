package com.CoralieP98.Web_app.Service;

import com.CoralieP98.Web_app.Model.Session;
import com.CoralieP98.Web_app.Model.User;
import com.CoralieP98.Web_app.Service.Client.ClimbFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionService {

    private final CustomUserDetailsService customUserDetailsService;

    private final ClimbFeignClient climbFeignClient;



}
