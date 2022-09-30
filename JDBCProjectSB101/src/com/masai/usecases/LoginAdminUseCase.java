package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.HODDao;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.exception.MyException;

public class LoginAdminUseCase {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		String username=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		
		HODDao dao=new HODDaoImpl();
		try {
		 boolean x=dao.loginHOD(username, password);
			System.out.println("Welcome "+ username+" !");
			System.out.println("---------------------------------------");
			if(x==true) {
				HODDriver.main(args);
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
