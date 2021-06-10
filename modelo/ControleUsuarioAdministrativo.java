package modelo;

import java.util.List;

public interface ControleUsuarioAdministrativo {
	public void inserirProduto(List<Produto> lista);
	public Produto editarProduto(List<Produto> lista);
	public void removerProduto(List<Produto> lista);
	public void imprimirProdutosPorTipo(List<Produto> lista);
	public void imprimirProdutosPorIntervalo(List<Produto> lista);
}
