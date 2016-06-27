package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOAutorImpl;
import entidade.Autor;

public class AutorControl implements TableModel {
	private DAOAutorImpl dao = new DAOAutorImpl();
	private List<Autor> lista = new ArrayList<Autor>();

	public void adicionar(Autor autor) {
		try {
			long id = autor.getId();
			if (id != 0) {
				dao.alterar(autor);
			} else {
				dao.adicionar(autor);
				lista.add(autor);
			}
			
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

	public List<Autor> pesquisar(String nome) {
		List<Autor> resultados = new ArrayList<Autor>();
		try {
			resultados = dao.pesquisar(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista = resultados;
		return resultados;
	}

	public Autor pesquisarPorId(Long id) {
		Autor a = new Autor();
		try {
			a = dao.pesquisarPorId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public void setLista(List<Autor> lista) {
		this.lista = lista;
	}

	public List<Autor> getLista() {
		return lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] nomes = { "ID", "Nome" };
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] classes = { Long.class, String.class };
		return classes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Autor a = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Autor a = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			a.setId( (Long) aValue);
		case 1:
			a.setNome((String) aValue);
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
