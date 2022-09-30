package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EngineerDao;
import com.masai.Dao.HODDao;
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.exception.MyException;

public class LoginEngineerUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username of Engineer");
		String username=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		
		EngineerDao dao=new EngineerDaoImpl();

		try {
		 boolean x=dao.EngineerLogin(username, password);
			System.out.println("Welcome "+ username+" !");
			System.out.println("---------------------------------------");
			if(x==true) {
				EngineerDriver.update(username);;
			}
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
