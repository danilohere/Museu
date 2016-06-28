package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entidade.Autor;
import entidade.Evento;

public class DAOEventoImpl implements DAOEvento{
	
	private Connection con;

	public DAOEventoImpl() {
		con = DAOUtil.getConnection();
	}
	
	@Override
	public void adicionar(Evento ev) throws SQLException {
		String sql = "INSERT INTO evento VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, 0);
		pst.setString(2, ev.getNome());
		pst.setString(3, ev.getDescricao());
		long dtini = ev.getDatainicio().getTime();
		java.sql.Date d1 = new java.sql.Date(dtini);
		pst.setDate(4, d1);
		long dtenc = ev.getDataenc().getTime();
		java.sql.Date d2 = new java.sql.Date(dtenc);
		pst.setDate(5, d2);
		pst.setFloat(6, ev.getValortot());
		pst.setFloat(7, ev.getValormeia());
		pst.setInt(8, ev.getQnting());
		pst.executeUpdate();				
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
			ev.setDescricao(rs.getString("descricao"));
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
		String sql = "DELETE FROM evento WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, id);
		pst.executeUpdate();
		pst.close();	
	}

	@Override
	public Evento pesquisarPorId(Long id) throws SQLException {
		Evento ev = new Evento();
		
		String sql = "SELECT * FROM evento WHERE id = ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, id);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			ev.setId(rs.getLong("id"));
			ev.setNome(rs.getString("nome"));
			ev.setDescricao(rs.getString("descricao"));
			ev.setDatainicio(rs.getDate("datainicio"));
			ev.setDataenc(rs.getDate("dataenc"));
			ev.setValortot(rs.getFloat("valortot"));
			ev.setValormeia(rs.getFloat("valormeia"));
			ev.setQnting(rs.getInt("qnting"));
		}
	
	return ev;
	}

	@Override
	public void alterar(Evento ev) throws SQLException {
		String sql = "UPDATE evento SET nome = ?, datainicio = ?, dataenc = ?, valortot = ?, valormeia = ?, qnting = ?"
				+ " WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, ev.getNome());
		long dtini = ev.getDatainicio().getTime();
		java.sql.Date d1 = new java.sql.Date(dtini);
		pst.setDate(2, d1);
		long dtenc = ev.getDataenc().getTime();
		java.sql.Date d2 = new java.sql.Date(dtenc);
		pst.setDate(3, d2);
		pst.setFloat(4, ev.getValortot());
		pst.setFloat(5, ev.getValormeia());
		pst.setInt(6, ev.getQnting());
		pst.setLong(7, ev.getId());
		pst.executeUpdate();		
	}

}
