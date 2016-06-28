package control;

import java.sql.SQLException;


import dao.DAOLoginImpl;
import entity.Login;

public class LoginControl {
	
	private DAOLoginImpl dao = new DAOLoginImpl();
	
	public Login pesquisarPorId(String usuario) {
		Login l = new Login();
		try {
 			l = dao.pesquisarPorId(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			l.setUsuario(null);
		}
		return l;
	}
}
