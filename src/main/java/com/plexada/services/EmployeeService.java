/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.model.employee.Company;

/**
 *
 * @author SAP Training
 */
public interface EmployeeService {
    Iterable<Company> listAllProducts();

    Company getEmployeeById(Integer id);

    Company save(Company product);

    void delete(Integer id);
}
