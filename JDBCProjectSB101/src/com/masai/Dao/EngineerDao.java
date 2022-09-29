package com.masai.Dao;

import com.masai.exception.MyException;

public interface EngineerDao {

	public boolean EngineerLogin(String username, String password)throws MyException;
}
