package com.masai.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Dao.EmployeeDao;
import com.masai.Driver.Driver;
import com.masai.bean.Complain;
import com.masai.bean.Employee;
import com.masai.bean.Engineer;
import com.masai.exception.MyException;
import com.masai.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String registerEmployee(Employee emp) {
		String message = "Unable to Add Employee";
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into Employee(name, email,username, password) value(?,?,?,?)");

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());

			int x = ps.executeUpdate();
			if (x > 0) {
				message = "Employee registration Successfull...";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public void registerComplain(Complain co) {
		
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps =conn.prepareStatement("insert into complain(complainName,category,empId) values(?,?,?)");

			ps.setString(1, co.getComplainName());
			ps.setString(2, co.getCategory());
			ps.setString(3, co.getEmpId());
		
			int rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("Complain registered Succesfully \n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	@Override
	public boolean loginEmployee(String username, String password) throws MyException {

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Employee where username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Employee Login Succesfull...");
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

			PreparedStatement ps = conn.prepareStatement("update Employee set password=? where username=?");

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
	public Complain seeStatus(int id) throws MyException {
		Complain c=new Complain();
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Complain where id=?");

			ps.setInt(1, id);
		

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String complainName = rs.getString("complainName");
				
				String engineer=rs.getString("engineer");
				String status=rs.getString("status");
				
				c.setComplainName(complainName);
				c.setId(id);
				c.setEngineer(engineer);
				c.setStatus(status);
				return c;
			}
		} catch (SQLException se) {

			throw new MyException(se.getMessage());
		}
	return c;
	}

	@Override
	public List<Complain> completedComplaintd(int id) throws MyException {
		List<Complain> list = new ArrayList<>();
       
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Complain where empId=?");
			ps.setInt(1, id );
			
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
