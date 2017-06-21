package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class DAOMainImpl implements DAOMain{
	
	private Connection con;
	
	public DAOMainImpl() {
		con = DAOUtil.getConnection();
	}

	@Override
	public String gerarRelatorio() throws SQLException {
		// TODO Auto-generated method stub
		String relatorio = "";
		String sql = "{call ProcRelatorio(?)}";
		CallableStatement stmt = con.prepareCall(sql);
		stmt.registerOutParameter(1, Types.VARCHAR);
		stmt.execute();
		
		relatorio = stmt.getString(1);
	

		System.out.println(relatorio);
		return relatorio;
		
	}

}
