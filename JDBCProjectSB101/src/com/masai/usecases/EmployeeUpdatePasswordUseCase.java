package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EngineerDao;
import com.masai.DaoImpl.EmployeeDaoImpl;
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.bean.Employee;
import com.masai.exception.MyException;

public class EmployeeUpdatePasswordUseCase {
	public static void update(String u) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the password to be set");
		String p=sc.next();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			String s=dao.updatePassword(u, p);
			System.out.println(s);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
