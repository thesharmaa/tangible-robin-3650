package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.HODDao;
import com.masai.bean.Engineer;

import DaoImpl.HODDaoImpl;

public class EngineerRegisterUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Username of Enginner");
		String username=sc.next();
		System.out.println("Enter Password of Enginner");
		String password=sc.next();
		System.out.println("Enter Category of Enginner");
		String category=sc.next();
		
		
		HODDao dao=new HODDaoImpl();
		Engineer e=new Engineer();
		e.setUsername(username);
		e.setPassword(password);
		e.setCategory(category);
		String res = dao.registerEngineer(e);
		System.out.println(res);
	}

}
