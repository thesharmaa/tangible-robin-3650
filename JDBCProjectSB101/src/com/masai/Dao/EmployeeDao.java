package com.masai.Dao;

import java.util.List;

import com.masai.bean.Complain;
import com.masai.bean.Employee;
import com.masai.exception.MyException;


public interface EmployeeDao {

 
	public String registerEmployee(Employee emp);
	
	public boolean loginEmployee(String username, String password)throws MyException;
	
	public void registerComplain(Complain co);
	
	public Complain seeStatus(int id) throws MyException;
	public String updatePassword(String username, String password)throws MyException;


	public List<Complain> completedComplaintd(int empId)throws MyException;


}
