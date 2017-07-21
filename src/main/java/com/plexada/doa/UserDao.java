/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.build.Company;
import com.plexada.model.registration.LoginModel;

/**
 *
 * @author SAP Training
 */
public interface UserDao {
    
    void register(Company company);
    Company validateUser(LoginModel loginModel);
    
}
