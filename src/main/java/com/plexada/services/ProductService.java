/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.domain.Company;

/**
 *
 * @author SAP Training
 */
public interface ProductService {
    Iterable<Company> listAllProducts();

    Company getProductById(Integer id);

    Company saveProduct(Company product);

    void deleteProduct(Integer id);
}
