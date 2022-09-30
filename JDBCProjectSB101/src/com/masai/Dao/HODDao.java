package com.masai.Dao;

import java.util.List;

import com.masai.bean.Complain;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;

public interface HODDao {

	public boolean loginHOD(String username, String password)throws MyException;


	public String registerEngineer(Engineer en);

	
	public List<Engineer> getAllEngineerDetails()throws MyException;
	

	public String deleteEngineer(String username)throws MyException;

	public List<Complain> getAllProblemDetails()throws MyException;
	
	public String assignEngineer(String cn,String username)throws MyException;
}
