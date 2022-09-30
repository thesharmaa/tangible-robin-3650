package com.masai.usecases;

import java.util.Scanner;

import com.masai.Driver.Driver;
import com.masai.exception.MyException;

public class EngineerDriver {

	public static void update(String u) {
		// TODO Auto-generated method stub
		while (true) {

			System.out.println("2. Get Assigned Complaints");
			System.out.println("3. Update the status of Complaints");
			System.out.println("4. Access List of All the Problems Solved");
			System.out.println("5. Update Password");
			System.out.println("6. Exit to Main Page");

			System.out.println("Please select an option to continue");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 2:
				AssignedComplaintsUseCase.assign(u);
				break;
			case 3:
				StatusUpdateUseCases.updateStatus(u);
				break;
			case 4:
				GetCompletedComplaintUseCases.CompletedComplaint(u);
				break;
			case 5:
				EngineerUpdatePasswordUseCases.update(u);
				break;

			case 6:
				try {
					Driver.main(null);
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
