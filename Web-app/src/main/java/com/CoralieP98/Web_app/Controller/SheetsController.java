package com.CoralieP98.Web_app.Controller;

import com.CoralieP98.Web_app.Service.Client.SheetsFeignClient;
import com.CoralieP98.Web_app.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SheetsController {

    private final SheetsFeignClient sheetsFeignClient;
    private final CustomUserDetailsService userDetailsService;



}
