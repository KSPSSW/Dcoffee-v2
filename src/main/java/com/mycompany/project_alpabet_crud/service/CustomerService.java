/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.CustomerDao;
import com.mycompany.project_alpabet_crud.model.Customer;
import java.util.List;

/**
 *
 * @author werapan
 */
public class CustomerService {
    
    public Customer getByTel(String tel) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getByTel(tel);
        return customer;
    }
    
    public List<Customer> getCustomers(){
        CustomerDao customerDao = new CustomerDao();
        return customerDao.getAll(" customer_id asc");
    }

    public Customer addNew(Customer editedCustomer) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.save(editedCustomer);
    }

    public Customer update(Customer editedCustomer) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.update(editedCustomer);
    }

    public int delete(Customer editedCustomer) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.delete(editedCustomer);
    }
  
}
