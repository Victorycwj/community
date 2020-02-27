package com.cwjee.community.controller;

import com.cwjee.community.mapper.QuestionMapper;
import com.cwjee.community.mapper.UserMapper;
import com.cwjee.community.model.Question;
import com.cwjee.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Victory
 * @date 2020/2/26 17:02:00
 * @decription
 */
@Controller
public class PublishController {

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    UserMapper userMapper;


    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(name = "title",required = false) String title,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "tag",required = false)String tag,
            HttpServletRequest request,
            Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);


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

        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies){
                if ("token".equals(cookie.getName())){
                    String token = cookie.getValue();
                     user = userMapper.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setDescription(description);
        question.setTitle(title);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());

        questionMapper.create(question);
        return "redirect:/";
    }

}
