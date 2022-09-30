package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.EngineerDao;
import com.masai.DaoImpl.EngineerDaoImpl;
import com.masai.bean.Complain;
import com.masai.exception.MyException;

public class AssignedComplaintsUseCase {

	public static void assign(String en) {
		Scanner sc = new Scanner(System.in);

		

		EngineerDao dao = new EngineerDaoImpl();
		try {
			List<Complain> e = dao.getAllEngineerDetails(en);
			e.forEach(s->{
				System.out.println("Complain Name : "+s.getComplainName());
				System.out.println("Complain Category : "+s.getCategory());
				System.out.println("Complain raised by Employee Id : "+s.getEmpId());
				System.out.println("Assigned Engineer : "+s.getEngineer());
				System.out.println("Complaint status : "+s.getStatus()+"\n");
			System.out.println("-------------------------------");
			});
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
