package com.masai.usecases;

import java.util.Scanner;

import com.masai.Driver.Driver;
import com.masai.exception.MyException;

public class EmployeeDriver {

	public static void update(String u) {
		// TODO Auto-generated method stub

		while (true) {

			System.out.println("3. Register Complaint");
            System.out.println("4. Check Status of Complaint and Assigned Engineer");
			System.out.println("5. See All Complaints Raised");
            System.out.println("6. Update Password");
			System.out.println("7. Exit To Main Page");
			System.out.println("Please select an option to continue");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 3:
				RegisterComplainUseCase.main(null);
				break;
			case 4:
				ComplainStatusCheckUseCase.main(null);
				break;
			case 5:
				CompletedComplaintUseCases.main(null);
				break;
			case 6:
				EmployeeUpdatePasswordUseCase.update(u);
				break;
			case 7:
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
