package com.iotek.Controller;

import com.iotek.po.Customer;
import com.iotek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * com.iotek.Controller
 *
 * @author <Author Administrator>
 * @date 2018/3/9 9:44
 */
@Controller
public class AllController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "")
    public String indexView(){
        return "redirect:customerLogin";
    }
    @RequestMapping(value = "customerLogin")
    public String customerLogin(HttpServletRequest httpServletRequest, Customer customer, HttpSession session, Model model){
        Cookie[] cookies=httpServletRequest.getCookies();
        if(cookies==null){
            return "index";
        }
        String customerName=null;
        String customerPassword=null;
        for (Cookie cookie : cookies) {
            if("customerName".equals(cookie.getName())){
                customerName=cookie.getValue();
            }
            if("customerPassword".equals(cookie.getName())){
                customerPassword=cookie.getValue();
            }
        }

        if(customerName==null||customerPassword==null){
                return  "index";
        }
        customer.setCustomerName(customerName);
        customer.setCustomerPassword(customerPassword);
        customer=customerService.findCustomerByName(customer);
        if(customer==null){
            model.addAttribute("info","登录失败!");
            return "index";
        }
        model.addAttribute("info","登录成功");
        session.setAttribute("customer",customer);
        return "success";
    }
    @RequestMapping(value = "customerRegisterFirst.view")
    public String register(){
        return "customerRegisterView";
    }
    @RequestMapping(value = "adminLoginFirst.view")
    public String adminLogin(){
        return "adminLoginView";
    }
}