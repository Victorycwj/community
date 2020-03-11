package com.cwjee.community.advice;

import com.cwjee.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Victory
 * @date 2020/3/10 21:42:45
 * @decription
 */
@ControllerAdvice("com.cwjee.community.controller")
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable e, Model model){

        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
    }else {
            model.addAttribute("message","服务冒烟啦，要不然稍等下再来试试~");
        }
        return new ModelAndView("error");
    }

}
