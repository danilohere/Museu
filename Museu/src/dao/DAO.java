package dao;

import java.util.List;

import entidade.Obra;

interface DAO {
	public void adicionar(Obra o);
	public List<Obra> pesquisar(String nome);
	public void excluir(long id);
	public Obra pesquisarPorId(Long id);
}
