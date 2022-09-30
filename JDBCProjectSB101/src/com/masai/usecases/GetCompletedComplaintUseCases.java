package com.masai.usecases;

import java.util.List;

import com.masai.Dao.EngineerDao;

import com.masai.DaoImpl.EngineerDaoImpl;

import com.masai.bean.Complain;

import com.masai.exception.MyException;

public class GetCompletedComplaintUseCases {

	public static void CompletedComplaint(String u) {
		EngineerDao hd=new EngineerDaoImpl();
		try {
			List<Complain> list = hd.completedComplaintd(u);
			list.forEach(s->{
					System.out.println("Complain Name is : "+ s.getComplainName());
					System.out.println("Complain Category is : "+ s.getCategory());
					System.out.println("Employee Id registered the complaint is : "+ s.getEmpId());
					System.out.println("-------------------------");
			});
		}catch(MyException e) {
			System.out.println(e.getMessage());
			System.out.println("---------------------------------------");
		}
	}
	 

}