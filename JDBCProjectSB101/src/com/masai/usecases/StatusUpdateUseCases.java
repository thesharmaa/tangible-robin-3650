package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EngineerDao;
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.exception.MyException;

public class StatusUpdateUseCases {


	public static void updateStatus(String u) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Complain Name to update the status");
		String cn=sc.next();
		
		EngineerDao dao= new EngineerDaoImpl();
		try {
			String res = dao.updateStatus(cn, u);
			System.out.println(res);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
