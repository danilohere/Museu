package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOUtil;
import entidade.Obra;

public class ObraControl implements TableModel {

	private List<Obra> lista = new ArrayList<Obra>();

	public void adicionar(Obra obra) {
		lista.add(obra);
		try {
			Connection con = DAOUtil.getConnection();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(long id) {
		try {
			Connection con = DAOUtil.getConnection();
			String sql = "DELETE FROM obra WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setLong(1, id);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Obra> pesquisar(String nome) {
		List<Obra> resultados = new ArrayList<Obra>();
		try {
			Connection con = DAOUtil.getConnection();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista = resultados;
		return resultados;
	}

	public Obra pesquisarPorId(Long id) {
		Obra o = new Obra();
		try {
			Connection con = DAOUtil.getConnection();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	public void setLista(List<Obra> lista) {
		this.lista = lista;
	}

	public List<Obra> getLista() {
		return lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] nomes = { "ID", "Nome", "Autor", "Descrição" };
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] classes = { Long.class, String.class, String.class, String.class };
		return classes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return o.getNome();
		case 1:
			return o.getAutor();
		case 2:
			return o.getDescricao();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			o.setNome((String) aValue);
		case 1:
			o.setAutor((String) aValue);
		case 2:
			o.setDescricao((String) aValue);
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
