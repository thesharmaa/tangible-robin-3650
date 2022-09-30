package com.masai.usecases;



import java.util.Scanner;

import com.masai.Dao.HODDao;
import com.masai.DaoImpl.HODDaoImpl;

public class DeleteUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Engineer name to be deleted");
		String username=sc.next();
		
		HODDao dao= new HODDaoImpl();
		try {	
			String res=dao.deleteEngineer(username);
			System.out.println(res);
		}catch(Exception se) {
			se.printStackTrace();
		}
           
	}
}
	
