package com.masai.usecases;

import java.util.List;

import com.masai.Dao.HODDao;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;

import DaoImpl.HODDaoImpl;

public class GetAllEngineerDetailsUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HODDao hd=new HODDaoImpl();
		try {
			List<Engineer> list = hd.getAllEngineerDetails();
			list.forEach(s->{
					System.out.println("Username is : "+ s.getUsername());
					System.out.println("Password is : "+ s.getPassword());
					System.out.println("Category is : "+ s.getCategory());
					System.out.println("-------------------------");
			});
		}catch(MyException e) {
			System.out.println(e.getMessage());
		}
	}

}
