package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Obra;

interface DAOObra {
	public void adicionar(Obra o) throws SQLException;
	public List<Obra> pesquisar(String nome) throws SQLException;
	public void excluir(long id) throws SQLException;
	public Obra pesquisarPorId(Long id) throws SQLException;
	public void alterar(Obra obra) throws SQLException;
}
