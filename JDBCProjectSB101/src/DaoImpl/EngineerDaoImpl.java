package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Dao.EngineerDao;
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

}
