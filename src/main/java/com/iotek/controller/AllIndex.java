package com.iotek.controller;

import com.iotek.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:51
 */
@Controller
public class AllIndex {
    /*指向总的一个登录界面*/
    @RequestMapping(value = "")
    public String jumpToIndex(){
        return "allIndex";
    }

}