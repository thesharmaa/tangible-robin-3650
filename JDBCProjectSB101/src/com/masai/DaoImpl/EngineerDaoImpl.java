package com.masai.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Dao.EngineerDao;
import com.masai.bean.Complain;
import com.masai.exception.MyException;
import com.masai.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao {

	@Override
	public boolean EngineerLogin(String username, String password) throws MyException {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Engineer where username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Engineer Login Succesfull...");
				return true;
			} else {
				throw new MyException("Invalid Username or Password");

			}

		} catch (SQLException se) {

			throw new MyException(se.getMessage());
		}

	}

	@Override
	public String updatePassword(String username, String password) throws MyException {
		String message = "Cannot Update";
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Engineer set password=? where username=?");

			ps.setString(1, password);
			ps.setString(2, username);

			int rs = ps.executeUpdate();

			if (rs > 0) {
				message = "Password Set Succesfully...";

			} 

		} catch (SQLException se) {

			throw new MyException(se.getMessage());
		}
		return message;
	}

	@Override
	public List<Complain> getAllEngineerDetails(String en) throws MyException {
		List<Complain> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Complain where engineer=? ");
			ps.setString(1, en);
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
	public String updateStatus(String cname, String u) throws MyException {
		String message = "Cannot Update";
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Complain set status=? where complainName=? and engineer=?" );

			ps.setString(1, "Completed");
			ps.setString(2, cname);
			ps.setString(3, u);

			int rs = ps.executeUpdate();

			if (rs > 0) {
				message = "Status updated Succesfully...";

			} 

		} catch (SQLException se) {

			throw new MyException(se.getMessage());
		}
		return message;
		
	}

	@Override
	public List<Complain> completedComplaintd(String u) throws MyException {
		List<Complain> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Complain where engineer=? AND status=?");
			ps.setString(1, u );
			ps.setString(2, "Completed");
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

}
