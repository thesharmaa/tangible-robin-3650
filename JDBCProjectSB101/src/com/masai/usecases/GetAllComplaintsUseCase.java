package com.masai.usecases;

import java.util.List;

import com.masai.Dao.HODDao;
import com.masai.DaoImpl.HODDaoImpl;
import com.masai.bean.Complain;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;

public class GetAllComplaintsUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HODDao hd=new HODDaoImpl();
		try {
			List<Complain> list = hd.getAllProblemDetails();
			list.forEach(s->{
					System.out.println("Complain Name is : "+ s.getComplainName());
					System.out.println("Complain Category is : "+ s.getCategory());
					System.out.println("Complained raised by Employee Id is : "+ s.getEmpId());
					System.out.println("Enginner Assigned is : "+s.getEngineer());
					System.out.println("Complaint Status : "+s.getStatus()+"\n");
					System.out.println("------------------------- \n");
			});
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}
	}

}
