/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.repositories;

/**
 *
 * @author SAP Training
 */

import com.plexada.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Company, Integer>{
}
