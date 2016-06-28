package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Autor;

public interface DAOAutor {
	public void adicionar(Autor a) throws SQLException;
	public List<Autor> pesquisar(String nome) throws SQLException;
	public void excluir(long id) throws SQLException;
	public Autor pesquisarPorId(Long id) throws SQLException;
	public void alterar(Autor autor) throws SQLException;
}
