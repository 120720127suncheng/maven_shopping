package com.iotek;
import com.iotek.po.Customer;
import com.iotek.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * com.iotek
 *
 * @author <Author Administrator>
 * @date 2018/3/7 11:36
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        /*CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        System.out.println(customerDao.addCustomer(new Customer()));*/
        CustomerService customerService= (CustomerService) context.getBean("customerService");
        Customer customer=new Customer();
        customer.setId(1);
        customer= customerService.findCustomerById(customer);
        System.out.println(customer);
    }
}