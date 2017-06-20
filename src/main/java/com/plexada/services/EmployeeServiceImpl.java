/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plexada.model.employee.Company;

/**
 *
 * @author SAP Training
 */
@Service
public class EmployeeServiceImpl{// implements EmployeeService{
    /*
    
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Iterable<Company> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Company getEmployeeById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Company save(Company product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }*/
}
