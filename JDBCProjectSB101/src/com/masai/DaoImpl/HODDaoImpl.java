package com.masai.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Dao.HODDao;
import com.masai.bean.Complain;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;
import com.masai.utility.DBUtil;

public class HODDaoImpl implements HODDao {

	@Override
	public boolean loginHOD(String username, String password) throws MyException {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from HOD where username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Admin Login Succesfull...");
				return true;
			} else {
				throw new MyException("Invalid Username or Password");

			}

		} catch (SQLException se) {

			throw new MyException(se.getMessage());
		}

	}

	@Override
	public String registerEngineer(Engineer en) {
		String message = "Unable to Add Engineer";
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into Engineer(username, password, category) value(?,?,?)");

			ps.setString(1, en.getUsername());
			ps.setString(2, en.getPassword());
			ps.setString(3, en.getCategory());

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Engineer registration Successfull...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public List<Engineer> getAllEngineerDetails() throws MyException {
		List<Engineer> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Engineer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String category = rs.getString("category");
				list.add(new Engineer(username, password, category));
			}
		} catch (SQLException se) {
			throw new MyException(se.getMessage());
		}
		if (list.size() == 0) {
			throw new MyException("No Engineer Found...");
		}
		return list;
	}

	@Override
	public String deleteEngineer(String username) throws MyException {

		String message = "Engineer not found...";

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from Engineer where username=?");
			ps.setString(1, username);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				return "Engineer Deleted from Database";
			}
		} catch (SQLException se) {
			throw new MyException(se.getMessage());
		}

		return message;
	}

	@Override
	public List<Complain> getAllProblemDetails() throws MyException {
		List<Complain> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Complain");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String complainName = rs.getString("complainName");
				String category = rs.getString("category");
				String empId= rs.getString("empId");
				String engineer=rs.getString("engineer");
				String status=rs.getString("status");
				Complain c=new Complain();
				c.setComplainName(complainName);
				c.setCategory(category);
				c.setEmpId(empId);
				c.setEngineer(engineer);
				c.setStatus(status);
				list.add(c);
			}
		} catch (SQLException se) {
			throw new MyException(se.getMessage());
		}
		if (list.size() == 0) {
			throw new MyException("No Complain Found...");
		}
		return list;
	}

	@Override
	public String assignEngineer(String cn,String username) throws MyException {
	   String message ="Unable to assign Engineer";
	   
	   try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("update Complain set engineer=?,status=? where complainName=?");

			ps.setString(1, username);
			ps.setString(2, "processing");
	        ps.setString(3, cn);

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Engineer assigned Successfully...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   return message;
	}

}
