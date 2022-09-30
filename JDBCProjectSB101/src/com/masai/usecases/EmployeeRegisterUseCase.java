package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.HODDao;
import com.masai.DaoImpl.EmployeeDaoImpl;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.Driver.Driver;
import com.masai.bean.Employee;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;

public class EmployeeRegisterUseCase {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name of Employee");
		String name=sc.next();
		System.out.println("Enter email of Employee");
		String email=sc.next();
		System.out.println("Enter username of Employee");
		String username=sc.next();
		System.out.println("Enter password of Employee");
		String password=sc.next();
		
		
		EmployeeDao dao=new EmployeeDaoImpl();
		Employee e=new Employee();
		e.setName(name);
		e.setEmail(email);
		e.setUsername(username);
		e.setPassword(password);
		String res = dao.registerEmployee(e);
		System.out.println(res);
		
		try {
			Driver.main(args);
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
