package com.iotek.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * com.iotek.Controller
 *
 * @author <Author Administrator>
 * @date 2018/3/9 13:49
 */
@ControllerAdvice
public class EceptionController {
    @ExceptionHandler
    public String error500(Exception e){
        return "redirect:/staticPages/500.html";
    }
}