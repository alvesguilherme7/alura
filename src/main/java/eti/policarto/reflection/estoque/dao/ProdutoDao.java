package eti.policarto.reflection.estoque.dao;

import eti.policarto.reflection.estoque.modelo.Produto;

import java.util.List;

public interface ProdutoDao {
	public List<Produto> lista();
	public Produto getProduto(Integer id);
}
