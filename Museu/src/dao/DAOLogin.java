package dao;

import java.sql.SQLException;

import entidade.Login;

public interface DAOLogin {
	public Login pesquisarPorId(String usuario) throws SQLException;
}
