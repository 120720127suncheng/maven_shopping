package com.iotek.service;

import com.iotek.po.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerByName(Customer customer);
    boolean addCustomer(Customer customer);
    List<Customer> queryAllCustomer();
    boolean updateCustomerName(Customer customer);
    boolean deleteCustomer(Customer customer);
    Customer findCustomerByIdAndName(String name, int id);
    Customer findCustomerById(Customer customer);
    Customer findCustomerName(String customerName);
    Customer findCustomerEmail(String customerEmail);
    Customer findCustomerPhone(String customerPhone);
}