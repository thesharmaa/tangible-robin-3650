package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EngineerDao;
import com.masai.Dao.HODDao;
<<<<<<< HEAD
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.exception.MyException;

=======
import com.masai.exception.MyException;

import DaoImpl.EngineerDaoImpl;
import DaoImpl.HODDaoImpl;

>>>>>>> main
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
<<<<<<< HEAD
			if(x==true) {
				EngineerDriver.update(username);;
			}
=======
>>>>>>> main
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
