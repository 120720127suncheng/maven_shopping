package com.iotek.Controller;

import com.iotek.po.Customer;
import com.iotek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * com.iotek.Controller
 *
 * @author <Author Administrator>
 * @date 2018/3/8 11:31
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "customerRegister.do")
    public String customerRegisterDo(@ModelAttribute Customer customer,Model model){
        boolean addCustomer = customerService.addCustomer(customer);
        if(addCustomer){
            model.addAttribute("info","注册成功");
            return "index";
        }
        model.addAttribute("info","注册失败");
        return "customerRegisterView";
    }
    @RequestMapping(value = "customerLogin.do")
    public String customerLoginDo(@ModelAttribute Customer customer, Model model, @RequestParam(value = "isRemember",required = false)String isRemember, HttpSession session, HttpServletResponse response){
            customer=customerService.findCustomerByName(customer);
            if(customer==null){
                model.addAttribute("info","信息错误,登录失败");
                return "index";
            }
            if("on".equals(isRemember)){
                Cookie cookieName=new Cookie("customerName",customer.getCustomerName());
                cookieName.setMaxAge(60*60*24);
                cookieName.setPath("/");
                Cookie cookiePassword=new Cookie("customerPassword",customer.getCustomerPassword());
                cookiePassword.setMaxAge(60*60*24);
                cookiePassword.setPath("/");
                response.addCookie(cookieName);
                response.addCookie(cookiePassword);
            }
            session.setAttribute("customer",customer);
            model.addAttribute("info","登陆成功");
            return "success";
    }
    @RequestMapping(value = "checkCustomerName.do")
    @ResponseBody
    public String checkCustomerName(String customerName){
       Customer customer= customerService.findCustomerName(customerName);
            if(customer==null){
                    return "is_not_exist";

            }else {
                    return "is_exist";
            }

    }
    @RequestMapping(value = "checkCustomerEmail.do")
    @ResponseBody
    public String checkCustomerEmail(String customerEmail){
        Customer customer= customerService.findCustomerEmail(customerEmail);
        if(customer==null){
            return "is_not_exist";
        }else {
            return "is_exist";
        }
    }
    @RequestMapping(value = "checkCustomerPhone.do")
    @ResponseBody
    public String checkCustomerPhone(String customerPhone){
        Customer customer= customerService.findCustomerPhone(customerPhone);
        if(customer==null){
            return "is_not_exist";
        }else {
            return "is_exist";
        }
    }
   /* @RequestMapping(value = "/registerCustomer")//存储一个键为customer1的customer对象，值为前端传来的name和password
    public String register(@ModelAttribute("customer1") Customer customer){
        customer.setId(11111111);
       return "success";
    }*/
    /*@RequestMapping(value = "/registerCustomer")//
    public String register(HttpServletRequest request){
        System.out.println(request.getParameter("customerName"));
        System.out.println(request.getParameter("customerPassword"));
        return "success";
    }*/
   /* @RequestMapping(value = "/registerCustomer")
    public String register(String customerName,String customerPassword){
        System.out.println(customerName);
        System.out.println(customerPassword);
        return "success";
    }*/
    /*@RequestMapping(value = "/loginCustomer/{id}/{oper}")
    public String login(@PathVariable(value = "id") int id, @PathVariable(value = "oper") String string, HttpSession session){
        System.out.println(id);
        System.out.println(string);
        session.setAttribute("id",id);
        return "success";
    }
    @ModelAttribute//这里会在model中存储一个键为customer的Customer对象，值里包含111111，同时也会把最上面的customer入参的值给赋进去
    public Customer  deleteCustomer(Customer customer2){
        customer2.setId(33333);
        return customer2;
    }*/
   /* @ModelAttribute//这里会在model中存储一个键为customer的Customer对象，值里包含111111，同时也会把最上面的customer入参的值给赋进去
    public Customer  addCustomer(Customer customer2){
            customer2.setId(00000);
            return customer2;
    }*/

}