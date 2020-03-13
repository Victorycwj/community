package com.cwjee.community.controller;

import com.cwjee.community.dto.QuestionDTO;
import com.cwjee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Victory
 * @date 2020/3/3 10:05:01
 * @decription
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable (name = "id")long id,
                           Model model){

        QuestionDTO questionDTO = questionService.getById(id);

        //累加阅读数
        questionService.inView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }


}
