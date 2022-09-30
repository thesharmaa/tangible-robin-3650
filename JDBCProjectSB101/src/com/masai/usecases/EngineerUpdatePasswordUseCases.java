package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EngineerDao;
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.exception.MyException;

public class EngineerUpdatePasswordUseCases {

	public static void update(String u) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the password to be set");
		String p=sc.next();
		
		EngineerDao dao=new EngineerDaoImpl();
		try {
			String s=dao.updatePassword(u, p);
			System.out.println(s);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
