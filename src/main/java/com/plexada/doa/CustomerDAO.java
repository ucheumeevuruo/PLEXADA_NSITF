/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.doa;

import com.plexada.build.Customer;
import java.util.List;

/**
 *
 * @author SAP Training
 */

public interface CustomerDAO 
{
	public void insert(Customer customer);
	
	public void insertNamedParameter(Customer customer);
			
	public void insertBatch(List<Customer> customer);
	
	public void insertBatchNamedParameter(List<Customer> customer);
	
	public void insertBatchNamedParameter2(List<Customer> customer);
			
	public void insertBatchSQL(String sql);
	
	public <T>Object findByObjectId(int custId);
	
	public Customer findByCustomerId2(int custId);

	public <T>List<T> findAll();
	
	public <T>List<T> findAll2();
	
	public String findCustomerNameById(int custId);
	
	public int findTotalCustomer();
	
}
