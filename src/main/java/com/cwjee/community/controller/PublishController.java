package com.cwjee.community.controller;

import com.cwjee.community.dto.QuestionDTO;
import com.cwjee.community.model.Question;
import com.cwjee.community.model.User;
import com.cwjee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Victory
 * @date 2020/2/26 17:02:00
 * @decription
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/publish/{id}")
    public String edit(@PathVariable("id") Integer id,
                       Model model){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",id);
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(name = "title",required = false) String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "tag",required = false)String tag,
            @RequestParam(name = "id",required = false)long id,
            HttpServletRequest request,
            Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        User user = (User) request.getSession().getAttribute("user");

        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        if (title == null || "".equals(title)){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description == null || "".equals(description)){
            model.addAttribute("error","description不能为空");
            return "publish";
        }
        if (tag == null || "".equals(tag)){
            model.addAttribute("error","tag不能为空");
            return "publish";
        }



        Question question = new Question();
        question.setDescription(description);
        question.setTitle(title);
        question.setTag(tag);
        question.setCreator(user.getAccountId());
        question.setId(id);

        questionService.createOrUpdate(question);
        return "redirect:/";
    }

}
