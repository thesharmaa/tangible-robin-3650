package com.masai.usecases;

import java.util.Scanner;

public class HODDriver {

	public static void main(String[] args) {
	
	
		System.out.println("1. Register Engineer");
		System.out.println("2. Get details of all Engineers");
		System.out.println("3. Delete an Engineer");
		while(true) {
			System.out.println("Please select an option to continue");
			
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
		     EngineerRegisterUseCase.main(args);
		     break;
		     
		case 2:
			GetAllEngineerDetailsUseCase.main(args);
			break;
		case 3:
			DeleteUseCase.main(args);
			break;
		}
		}
		
	}
}
