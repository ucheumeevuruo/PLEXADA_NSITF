/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

/**
 *
 * @author SAP Training
 */
import com.plexada.domain.Company;
import com.plexada.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
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
    public Company getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Company saveProduct(Company company) {
        return productRepository.save(company);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }
}
