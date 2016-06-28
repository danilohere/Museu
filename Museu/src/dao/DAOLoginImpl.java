package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Login;

public class DAOLoginImpl implements DAOLogin{

	private Connection con;
	
	public DAOLoginImpl() {
		con = DAOUtil.getConnection();
	}
	
	@Override
	public Login pesquisarPorId(String usuario) throws SQLException {
		Login l = new Login();
		
		String sql = "SELECT * FROM login WHERE usuario = ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, usuario);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			l.setUsuario(rs.getString("usuario"));
			l.setSenha(rs.getString("senha"));
		}
	
	return l;
	}

}
