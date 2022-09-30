package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.DaoImpl.EmployeeDaoImpl;
import com.masai.bean.Complain;
import com.masai.exception.MyException;

public class CompletedComplaintUseCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Employee ID");
		int empId=sc.nextInt();
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			List<Complain> list=dao.completedComplaintd(empId);
			list.forEach(s->{
				System.out.println("Complain name : "+s.getComplainName() );
				System.out.println("Complain id : "+s.getId());
				System.out.println("Assigned Engineer : "+s.getEngineer());
				System.out.println("Complaint status : "+s.getStatus());
				System.out.println("----------------------------------------");
			});
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
