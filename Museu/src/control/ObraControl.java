package control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import db.DbUtil;
import entidade.Obra;
public class ObraControl implements TableModel {
	
	private List<Obra> lista = new ArrayList<Obra>();

	public void adicionar (Obra obra){		
		lista.add(obra);
		try{
		Connection con = DbUtil.getConnection();
		String sql = "INSERT INTO obra_table VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pst = con.prepareStatement(sql);
		//pst.setLong(1, obra.getId());
		pst.setString(2, obra.getNome());
		pst.setString(3, obra.getAutor());
		pst.setString(4, obra.getDescricao());
		pst.setString(2, obra.getCategoria());
		pst.setString(2, obra.getMaterial());
		pst.setString(3, obra.getDimensoes());
		pst.setInt(4, obra.getAno());
		pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void excluir(long id) {
		try{
			Connection con = DbUtil.getConnection();
			String sql = "DELETE FROM obra_table WHERE id = ?";
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
	
	public List<Obra> pesquisar(String nome){
		List<Obra> resultados = new ArrayList<Obra>();
		try{
			Connection con = DbUtil.getConnection();
			String sql = "SELECT * FROM obra_table WHERE nome like ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + nome + "%");
						
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				Obra o = new Obra();
				o.setId(rs.getLong("id"));
				o.setNome(rs.getString("nome"));
				o.setAutor(rs.getString("autor"));
				o.setDescricao(rs.getString("descricao"));
				o.setCategoria(rs.getString("categoria"));
				o.setMaterial(rs.getString("material"));
				o.setDimensoes(rs.getString("dimensoes"));
				o.setAno(rs.getInt("ano"));
				resultados.add(o);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista = resultados;
		return resultados;
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
		return 7;
	}
	@Override
	public String getColumnName(int columnIndex) {
//		switch( columnIndex ) {
//			case 0 : return "Id";
//			case 1 : return "Numero";
//			case 2 : return "Descricao";
//			case 3 : return "Entrega";
//		}
//		return "";
		String [] nomes = {"Nome", "Autor", "Descrição", "Categoria", "Material", "Dimensões", "Ano"};
		return nomes[columnIndex];
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
//		switch( columnIndex ) {
//			case 0 : return Long.class;
//			case 1 : return Integer.class;
//			case 2 : return String.class;
//			case 3 : return Date.class;
//		}
		Class<?> [] classes = {String.class, String.class, String.class, String.class, String.class,
								String.class, Integer.class };
		return classes[columnIndex];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0: return o.getNome();
			case 1: return o.getAutor();
			case 2: return o.getDescricao();
			case 3: return o.getCategoria();
			case 4: return o.getMaterial();
			case 5: return o.getDimensoes();
			case 6: return o.getAno();
		}
		return "";
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch( columnIndex ) { 
			case 0: o.setNome((String) aValue);
			case 1: o.setAutor((String) aValue);
			case 2: o.setDescricao((String) aValue);
			case 3: o.setCategoria((String) aValue);
			case 4: o.setMaterial((String) aValue);
			case 5: o.setDimensoes((String) aValue);
			case 6: o.setAno((Integer) aValue);
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
