package control;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOEventoImpl;
import entity.Evento;

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
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Evento não encontrado");
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
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] nomes = { "ID", "Nome", "Descrição", "Data de Início"};
		return nomes[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?>[] classes = { Long.class, String.class, String.class, Date.class };
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
			return ev.getNome();
		case 2:
			return ev.getDescricao();
		case 3:
			return ev.getDatainicio();
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
			ev.setDescricao((String) aValue);
		case 3:
			ev.setDatainicio((Date) aValue);
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}
}
