package Com.InstituteHub.Dao;
import java.sql.*;

import Com.InstituteHub.Util.DBUtil;
public class UserDaoImpl implements UserDao {

	@Override
	public boolean isValidUser(String username, String password) {
	String query = "SELECT * FROM student_details WHERE student_email = ? AND student_password = ?";
		try{Connection connection = DBUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			
			ResultSet resultset = preparedStatement.executeQuery();
			System.out.println("Query SuccessFully Exceuteeed...Buddyy");
			return resultset.next();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}

}

