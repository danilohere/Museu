package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Evento;

public class DAOEventoImpl implements DAOEvento{
	
	private Connection con;

	public DAOEventoImpl() {
		con = DAOUtil.getConnection();
	}
	
	@Override
	public void adicionar(Evento a) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Evento> pesquisar(String nome) throws SQLException {
		List<Evento> resultados = new ArrayList<Evento>();
		
		String sql = "SELECT * FROM evento WHERE nome like ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "%" + nome + "%");

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Evento ev = new Evento();
			ev.setId(rs.getLong("id"));
			ev.setNome(rs.getString("nome"));
			ev.setDatainicio(rs.getDate("datainicio"));
			ev.setDataenc(rs.getDate("dataenc"));
			ev.setValortot(rs.getFloat("valortot"));
			ev.setValormeia(rs.getFloat("valormeia"));
			ev.setQnting(rs.getInt("qnting"));
			resultados.add(ev);
		}
	
	return resultados;
	}

	@Override
	public void excluir(long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evento pesquisarPorId(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Evento ev) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
