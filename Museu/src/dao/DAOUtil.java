package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtil {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Classe carregada");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//Connection con = DriverManager.getConnection(url, "root", "root");
			Connection con = DriverManager.getConnection(url, "system", "alunofatec");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
