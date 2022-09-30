package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.HODDao;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.exception.MyException;

public class AssigningEngineerUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Choose Complain Name");
		 String cn=sc.next();
		System.out.println("Enter the Engineer name");
		String ename=sc.next();
		
		
		
		HODDao dao=new HODDaoImpl();
		try {
			String res=dao.assignEngineer(cn,ename);
			System.out.println(res);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
