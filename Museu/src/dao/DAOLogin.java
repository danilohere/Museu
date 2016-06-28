package dao;

import java.sql.SQLException;

import entity.Login;

public interface DAOLogin {
	public Login pesquisarPorId(String usuario) throws SQLException;
}
