/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.domain.Company;
import com.plexada.build.OwnersParticular;
import com.siebel.customui.InsertUpdateCompany1Input;
import com.siebel.customui.InsertUpdateCompany1Output;
import com.siebel.customui.NSITFSpcEmployerSpcInsertUpdateSpcWF;
import com.siebel.customui.NSITFSpcEmployerSpcInsertUpdateSpcWF_Service;
import com.siebel.eai.SiebelBusinessServiceException;
import com.siebel.xml.wsaccount.Account;
import com.siebel.xml.wsaccount.ListOfSampleAccount;
import org.springframework.stereotype.Service;

/**
 *
 * @author SAP Training
 */
@Service
public class CompanyService{
    public void insert(Company company) throws SiebelBusinessServiceException{
        
        try { // Call Web Service Operation
            NSITFSpcEmployerSpcInsertUpdateSpcWF_Service service = new NSITFSpcEmployerSpcInsertUpdateSpcWF_Service();
            NSITFSpcEmployerSpcInsertUpdateSpcWF port = service.getNSITFSpcEmployerSpcInsertUpdateSpcWF();
            // TODO initialize WS operation arguments here
            Account a = new Account();
            a.setName(company.getCompany());
            a.setIncorporationNo(company.getIncNumber());
            a.setCSN(company.getTinNum());
            a.setEmployerEmailAddress(company.getEmail());
            a.setMobilePhoneNumber(company.getPhoneNumber());
            a.setYearIncorporated(company.getIncYear());
            a.setLocation(company.getHouseNo() + company.getStreetName());
            a.setOwnersFirstName(company.getfirstName());
            a.setOwnersLastName(company.getlastName());
            a.setOwnersIdExpiryDate(company.getexpiryDate());
            a.setOwnersPhoneNum(company.getphoneNumber2());
            a.setOwnersPhoneNum(company.getphoneNumber2());
            InsertUpdateCompany1Input insert = new InsertUpdateCompany1Input();
            ListOfSampleAccount acc = insert.getListOfSampleAccount();
            acc.setAccount(a);
            // TODO process result here
            InsertUpdateCompany1Output result = port.insertUpdateCompany1(insert);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            throw new SiebelBusinessServiceException("CONN_EXCPT", ex.getMessage());
        }
    }
}
