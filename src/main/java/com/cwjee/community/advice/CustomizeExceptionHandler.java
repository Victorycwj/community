package com.cwjee.community.advice;

import com.cwjee.community.exception.CustomizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Victory
 * @date 2020/3/10 21:42:45
 * @decription
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    ModelAndView handle(HttpServletRequest request, Exception e){

        final String DEFAULT_ERROR_VIEW = "error";

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof CustomizeException){
            modelAndView.addObject("exception", e);
            modelAndView.addObject("message",e.getMessage());
            modelAndView.setViewName(DEFAULT_ERROR_VIEW);
    }else {
            modelAndView.addObject("message","服务冒烟啦，要不然稍等下再来试试~");
            modelAndView.addObject("exception", e);
            modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        }
        return modelAndView;
    }

}
