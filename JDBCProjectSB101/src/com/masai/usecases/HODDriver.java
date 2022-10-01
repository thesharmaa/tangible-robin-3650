package com.masai.usecases;

import java.util.Scanner;


import com.masai.Driver.Driver;
import com.masai.exception.MyException;

public class HODDriver {

	public static void main(String[] args) {

		while (true) {

			System.out.println("1. Register Engineer");
			System.out.println("2. Get details of all Engineers");
			System.out.println("3. Delete an Engineer");
			System.out.println("4. Get all complaints registered");
			System.out.println("5. Assign Engineer");
			System.out.println("6. To Main Page \n");
			System.out.println("Please select an option to continue \n");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				EngineerRegisterUseCase.main(args);
				break;

			case 2:
				GetAllEngineerDetailsUseCase.main(args);
				break;
			case 3:
				DeleteUseCase.main(args);
				break;
			case 4:
				GetAllComplaintsUseCase.main(args);
				break;
			case 5:
				AssigningEngineerUseCase.main(args);
				break;
			case 6:
				try {
					Driver.main(args);
				} catch (MyException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
