package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Evento;

public interface DAOEvento {
	public void adicionar(Evento a) throws SQLException;
	public List<Evento> pesquisar(String nome) throws SQLException;
	public void excluir(long id) throws SQLException;
	public Evento pesquisarPorId(Long id) throws SQLException;
	public void alterar(Evento ev) throws SQLException;
}