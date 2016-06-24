package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Classe carregada");
			String url = "jdbc:mysql://localhost:3306/os";
			Connection con = DriverManager.getConnection(url, "root", "aluno");
			return con;
			// System.out.println("Conexão criada com sucesso");
			// Statement stmt = con.createStatement();
			// int i = stmt.executeUpdate("INSERT INTO os_table VALUES" + "(0,
			// 1, 'liberacao de senha', '2016-06-01')");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
