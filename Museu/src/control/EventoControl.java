package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOEventoImpl;
import entidade.Evento;

public class EventoControl implements TableModel {

	private DAOEventoImpl dao = new DAOEventoImpl();
	private List<Evento> lista = new ArrayList<Evento>();

	public void adicionar(Evento evento) {
		try {
			long id = evento.getId();
			if (id != 0) {
				dao.alterar(evento);
			} else {
				dao.adicionar(evento);
				lista.add(evento);
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

	public List<Evento> pesquisar(String nome) {
		List<Evento> resultados = new ArrayList<Evento>();
		try {
			resultados = dao.pesquisar(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista = resultados;
		return resultados;
	}

	public Evento pesquisarPorId(Long id) {
		Evento ev = new Evento();
		try {
 			ev = dao.pesquisarPorId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ev;
	}

	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	public List<Evento> getLista() {
		return lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] nomes = { "ID", "Nome", "Data de In�cio", "Data de Encerramento" };
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] classes = { Long.class, String.class, String.class };
		return classes[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Evento ev = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return ev.getId();
		case 1:
			return ev.getDatainicio();
		case 2:
			return ev.getDataenc();
		}
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Evento ev = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			ev.setId( (Long) aValue);
		case 1:
			ev.setNome((String) aValue);
		case 2:
//			ev.setDatainicio((String) aValue);
		case 3:
//			ev.setDataenc((String) aValue);
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
