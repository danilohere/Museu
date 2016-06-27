package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Obra;

public class DAOImpl implements DAO {

	private Connection con;

	public DAOImpl() {
		con = DAOUtil.getConnection();
	}

	public void adicionar(Obra obra) throws SQLException {
		String sql = "INSERT INTO obra VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, 0);
		pst.setString(2, obra.getNome());
		pst.setString(3, obra.getAutor());
		pst.setString(4, obra.getDescricao());
		pst.setString(5, obra.getCategoria());
		pst.setString(6, obra.getMaterial());
		pst.setString(7, obra.getDimensoes());
		pst.setInt(8, obra.getAno());
		pst.setString(9, obra.getImagem());
		pst.executeUpdate();

	}
	
	public void alterar(Obra obra) throws SQLException {
		String sql = "UPDATE obra SET nome = ?, autor = ?, descricao = ?, categoria = ?, material = ?, dimensoes = ?,"
				+ " ano = ?, imagem = ? WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, obra.getNome());
		pst.setString(2, obra.getAutor());
		pst.setString(3, obra.getDescricao());
		pst.setString(4, obra.getCategoria());
		pst.setString(5, obra.getMaterial());
		pst.setString(6, obra.getDimensoes());
		pst.setInt(7, obra.getAno());
		pst.setString(8, obra.getImagem());
		pst.setLong(9, obra.getId());
		pst.executeUpdate();

	}

	public void excluir(long id) throws SQLException {
		String sql = "DELETE FROM obra WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, id);
		pst.executeUpdate();
		pst.close();
	}

	public List<Obra> pesquisar(String nome) throws SQLException {
		List<Obra> resultados = new ArrayList<Obra>();
		
			String sql = "SELECT * FROM obra WHERE nome like ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + nome + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Obra o = new Obra();
				o.setId(rs.getLong("id"));
				o.setNome(rs.getString("nome"));
				o.setAutor(rs.getString("autor"));
				o.setDescricao(rs.getString("descricao"));
				o.setCategoria(rs.getString("categoria"));
				o.setMaterial(rs.getString("material"));
				o.setDimensoes(rs.getString("dimensoes"));
				o.setAno(rs.getInt("ano"));
				o.setImagem(rs.getString("imagem"));
				resultados.add(o);
			}
		
		return resultados;
	}

	public Obra pesquisarPorId(Long id) throws SQLException {
		Obra o = new Obra();
		
			String sql = "SELECT * FROM obra WHERE id = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				o.setId(rs.getLong("id"));
				o.setNome(rs.getString("nome"));
				o.setAutor(rs.getString("autor"));
				o.setDescricao(rs.getString("descricao"));
				o.setCategoria(rs.getString("categoria"));
				o.setMaterial(rs.getString("material"));
				o.setDimensoes(rs.getString("dimensoes"));
				o.setAno(rs.getInt("ano"));
				o.setImagem(rs.getString("imagem"));
			}
		
		return o;
	}

}
