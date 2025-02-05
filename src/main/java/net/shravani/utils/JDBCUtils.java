package net.shravani.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class JDBCUtils {
private static String jdbcURL = "jdbc:mysql://localhost:3306/demo";
private static String jdbcUsername = "root";
private static String jdbcPassword = "pass123";

public static Connection getConnection() {
	Connection con= null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return con;
}

public static void printSQLException(SQLException ex) {
	for(Throwable e: ex) {
		if(e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState:" + ((SQLException) e).getSQLState());
			System.err.println("Error code:" + ((SQLException) e).getErrorCode());
			System.err.println("Message:" + e.getMessage());
			Throwable t= ex.getCause();
			while(t!=null) {
				System.out.println("Cause:"+t);
				t=t.getCause();
				
			}
		}
	}
}
public static Date getSQLDate(LocalDate date) {
	return java.sql.Date.valueOf(date);
}

public static LocalDate getUtilDate(Date sqlDate) {
	return sqlDate.toLocalDate();
}

}
