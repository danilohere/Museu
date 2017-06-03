package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Autor;

public class DAOAutorImpl implements DAOAutor {

	private Connection con;

	public DAOAutorImpl() {
		con = DAOUtil.getConnection();
	}

	@Override
	public void adicionar(Autor a) throws SQLException {
		String sql = "INSERT INTO autor VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, 0);
		pst.setString(2, a.getNome());
		pst.setString(3, a.getNasc());
		pst.setString(4, a.getPeriodo());
		pst.setString(5, a.getBiografia());
		pst.executeUpdate();		
	}

	@Override
	public List<Autor> pesquisar(String nome) throws SQLException {
		List<Autor> resultados = new ArrayList<Autor>();
		
		String sql = "SELECT * FROM autor WHERE nome like ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "%" + nome + "%");

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			Autor a = new Autor();
			a.setId(rs.getLong("id"));
			a.setNome(rs.getString("nome"));
			a.setNasc(rs.getString("nasc"));
			a.setPeriodo(rs.getString("periodo"));
			a.setBiografia(rs.getString("biografia"));
			resultados.add(a);
		}
	
	return resultados;
	}

	@Override
	public void excluir(long id) throws SQLException {
		String sql = "DELETE FROM autor WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, id);
		pst.executeUpdate();
		pst.close();		
	}

	@Override
	public Autor pesquisarPorId(Long id) throws SQLException {
		Autor a = new Autor();
		
		String sql = "SELECT * FROM autor WHERE id = ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, id);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			a.setId(rs.getLong("id"));
			a.setNome(rs.getString("nome"));
			a.setNasc(rs.getString("nasc"));
			a.setPeriodo(rs.getString("periodo"));
			a.setBiografia(rs.getString("biografia"));
		}
	
	return a;
	}

	@Override
	public void alterar(Autor a) throws SQLException {
		String sql = "UPDATE autor SET nome = ?, nasc = ?, periodo = ?, biografia = ? WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, a.getNome());
		pst.setString(2, a.getNasc());
		pst.setString(3, a.getPeriodo());
		pst.setString(4, a.getBiografia());
		pst.setLong(5, a.getId());
		pst.executeUpdate();		
	}

}
