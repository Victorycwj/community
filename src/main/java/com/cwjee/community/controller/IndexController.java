package com.cwjee.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Victory
 * @date 2020/1/6 09:55:05
 * @decription
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String Index(){

        return "index";
    }

}
