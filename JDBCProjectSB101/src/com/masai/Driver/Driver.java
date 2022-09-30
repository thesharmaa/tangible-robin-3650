package com.masai.Driver;

import java.util.Scanner;

import com.masai.exception.MyException;
import com.masai.usecases.EmployeeRegisterUseCase;
import com.masai.usecases.HODDriver;
import com.masai.usecases.LoginAdminUseCase;
import com.masai.usecases.LoginEmployeeUseCase;
import com.masai.usecases.LoginEngineerUseCase;

public class Driver {

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Online Hardware and Software Support System");
		System.out.println("1. Login as HOD");
		System.out.println("2. Login as Engineer");
		System.out.println("3. Register as Employee");
		System.out.println("4. Login as Employee");

		Scanner sc=new Scanner(System.in);
		int res=sc.nextInt();
		if(res==1) {
			
			LoginAdminUseCase.main(args);
			
		}
		else if(res==2) {
			LoginEngineerUseCase.main(args);
		}
		else if(res==3) {
		    EmployeeRegisterUseCase.main(args);
		}
		else if(res==4) {
			LoginEmployeeUseCase.main(args);
			
		}
		
		else {
			throw new MyException("Invalid Input");
		}
	}

}
