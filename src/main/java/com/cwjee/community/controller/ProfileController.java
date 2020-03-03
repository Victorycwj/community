package com.cwjee.community.controller;

import com.cwjee.community.dto.PaginationDTO;
import com.cwjee.community.mapper.UserMapper;
import com.cwjee.community.model.User;
import com.cwjee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Victory
 * @date 2020/3/1 11:27:13
 * @decription
 */
@Controller
public class ProfileController {


    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;


    @GetMapping("profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "5")Integer size){


        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }

        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");

        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","我的提问");

        }

        PaginationDTO myquestions = questionService.list(user.getAccountId(), page, size);
        model.addAttribute("pagination",myquestions);
        return "profile";
    }

}
