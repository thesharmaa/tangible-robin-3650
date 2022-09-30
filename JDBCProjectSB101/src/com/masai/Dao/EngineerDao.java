package com.masai.Dao;

<<<<<<< HEAD
import java.util.List;

import com.masai.bean.Complain;
import com.masai.bean.Engineer;
=======
>>>>>>> main
import com.masai.exception.MyException;

public interface EngineerDao {

	public boolean EngineerLogin(String username, String password)throws MyException;
<<<<<<< HEAD
	public String updatePassword(String username, String password)throws MyException;
	public List<Complain> getAllEngineerDetails(String en)throws MyException;
    public String updateStatus(String cname, String u) throws MyException;
    public List<Complain> completedComplaintd(String u)throws MyException;
=======
>>>>>>> main
}
