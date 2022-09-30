package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.DaoImpl.EmployeeDaoImpl;
import com.masai.bean.Complain;

public class RegisterComplainUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the complain name");
		String cname=sc.next();
		System.out.println("Enter the complain category");
		String category=sc.next();
		System.out.println("Enter the Employee Id ");
		String empId=sc.next();
		
		Complain c=new Complain();
		EmployeeDao dao= new EmployeeDaoImpl();
		c.setComplainName(cname);
		c.setCategory(category);
		c.setEmpId(empId);
		dao.registerComplain(c);
	}

}
