package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;

import com.masai.DaoImpl.EmployeeDaoImpl;

import com.masai.exception.MyException;

public class LoginEmployeeUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username of Employee");
		String username=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		
		EmployeeDao dao=new EmployeeDaoImpl();

		try {
		 boolean x=dao.loginEmployee(username, password);
			System.out.println("Welcome "+ username+" !");
			System.out.println("---------------------------------------");
			if(x==true) {
				EmployeeDriver.update(username);;
			}
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
