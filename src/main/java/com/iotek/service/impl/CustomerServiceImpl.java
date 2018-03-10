package com.iotek.service.impl;
import com.iotek.dao.CustomerMapper;
import com.iotek.po.Customer;
import com.iotek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Component(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer findCustomerByName(Customer customer) {
        return customerMapper.findCustomerByName(customer);
    }
    @Override
    public boolean addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    @Override
    public List<Customer> queryAllCustomer() {
        return null;
    }

    @Override
    public boolean updateCustomerName(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomerByIdAndName(String name, int id) {
        return null;
    }

    @Override
    public Customer findCustomerById(Customer customer) {
        return customerMapper.findCustomerById(customer);
    }

    @Override
    public Customer findCustomerName(String customerName) {
        return customerMapper.findCustomerName(customerName);
    }

    @Override
    public Customer findCustomerEmail(String customerEmail) {
        return customerMapper.findCustomerEmail(customerEmail);
    }

    @Override
    public Customer findCustomerPhone(String customerPhone) {
        return customerMapper.findCustomerPhone(customerPhone);
    }
}