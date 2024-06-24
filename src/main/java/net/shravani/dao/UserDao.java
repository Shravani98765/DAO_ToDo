package net.shravani.dao;
import java.sql.Connection;
import java.sql.Connection.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.shravani.utils.JDBCUtils;
import net.shravani.model.User;
public class UserDao {

	public int registerEmployee(User employee) throws ClassNotFoundException{
		String sqlString="INSERT INTO users (first_name, last_name, username, password) VALUES (?,?,?,?)";
		int result=0;
		try(Connection con=JDBCUtils.getConnection()){
			PreparedStatement ps=con.prepareStatement(sqlString);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getUsername());
			ps.setString(4, employee.getPassword());
			System.out.println(ps);
			result=ps.executeUpdate();
		}
		catch(SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		
		return result;
	}
}
