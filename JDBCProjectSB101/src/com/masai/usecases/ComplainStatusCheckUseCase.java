package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.DaoImpl.EmployeeDaoImpl;
import com.masai.bean.Complain;
import com.masai.bean.Employee;
import com.masai.exception.MyException;

public class ComplainStatusCheckUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id of Complain");
		int id=sc.nextInt();
		EmployeeDao em=new EmployeeDaoImpl();
		try {
			Complain c=em.seeStatus(id);
			System.out.println("Complain name : "+c.getComplainName() );
			System.out.println("Complain id : "+c.getId());
			System.out.println("Assigned Engineer : "+c.getEngineer());
			System.out.println("Complaint status : "+c.getStatus());
			System.out.println("----------------------------------------");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
