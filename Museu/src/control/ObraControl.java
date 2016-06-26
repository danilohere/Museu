package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOImpl;
import entidade.Obra;

public class ObraControl implements TableModel {

	private DAOImpl dao = new DAOImpl();
	private List<Obra> lista = new ArrayList<Obra>();

	public void adicionar(Obra obra) {
		try {
			dao.adicionar(obra);
			lista.add(obra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir(long id) {
		try {
			dao.excluir(id);
			pesquisar("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Obra> pesquisar(String nome) {
		List<Obra> resultados = new ArrayList<Obra>();
		try {
			resultados = dao.pesquisar(nome);
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
			o = dao.pesquisarPorId(id);
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
			return o.getId();
		case 1:
			return o.getNome();
		case 2:
			return o.getAutor();
		case 3:
			return o.getDescricao();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Obra o = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			o.setId( (Long) aValue);
		case 1:
			o.setNome((String) aValue);
		case 2:
			o.setAutor((String) aValue);
		case 3:
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
