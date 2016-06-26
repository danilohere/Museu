package dao;

import java.sql.SQLException;
import java.util.List;

import entidade.Obra;

interface DAO {
	public void adicionar(Obra o) throws SQLException;
	public List<Obra> pesquisar(String nome) throws SQLException;
	public void excluir(long id) throws SQLException;
	public Obra pesquisarPorId(Long id) throws SQLException;
}
