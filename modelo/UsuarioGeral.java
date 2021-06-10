package modelo;

import java.util.List;

public class UsuarioGeral  extends Usuario{
	
	UsuarioGeral(String usuario, String senha){
		super(usuario, senha);
	}
	@Override
	public String toString() {
		return this.getUsuario() + "  -  " + this.getSenha();
	}
	
	@Override
	public void imprimirProdutos(List<Produto> lista) {
		for (Produto produto : lista) {
			System.out.println("Nome do produto: " + produto.getNome());
			System.out.println("Preço do produto: " + produto.getPreco());
			System.out.println("Tipo do produto: " + produto.getTipo().nome);
			System.out.println("======================================");
		}
		
	}
	
	public void verificarProduto(Produto produto) {
		System.out.println("Nome do produto: " + produto.getNome());
		System.out.println("Preço do produto: " + produto.getPreco());
		System.out.println("Tipo do produto: " + produto.getTipo().nome);
		System.out.println("======================================");
	};
	
	

}
