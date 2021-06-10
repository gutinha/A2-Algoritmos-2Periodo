package modelo;

import java.util.List;
import java.util.Scanner;
public class UsuarioAdministrativo extends Usuario{
	Scanner scan = new Scanner(System.in);
	
	UsuarioAdministrativo(String usuario, String senha){
		super(usuario, senha);
	}
	
	@Override
	public void imprimirProdutos(List<Produto> lista) {
		for (Produto produto : lista) {
			System.out.println("Identificador único:"  + produto.getIdentificador());
			System.out.println("Nome do produto: " + produto.getNome());
			System.out.println("Preço do produto: " + produto.getPreco());
			System.out.println("Tipo do produto: " + produto.getTipo().nome);
			System.out.println("Quantidade no estoque: " + produto.getEstoque());
			System.out.println("======================================");
		}
	}
	
	@Override
	public String toString() {
		return this.getUsuario() + "  -  " + this.getSenha();
	}
	
	public void imprimirProdutosPorTipo(List<Produto> lista) {
		for(TipoProduto tipo : TipoProduto.values()) {
			System.out.println(tipo.getId() + "    "   + tipo.getNome());
		}
		System.out.println("Insira o numero do tipo do produto: " );
		int tipo = Integer.parseInt(scan.next());
		for (Produto produto : lista) {
			if(produto.getTipo().equals(TipoProduto.values()[tipo - 1])) {
			System.out.println("Identificador único:"  + produto.getIdentificador());
			System.out.println("Nome do produto: " + produto.getNome());
			System.out.println("Preço do produto: " + produto.getPreco());
			System.out.println("Tipo do produto: " + produto.getTipo().nome);
			System.out.println("Quantidade no estoque: " + produto.getEstoque());
			System.out.println("======================================");
			}
		}
	}
	
	public void imprimirProdutosPorIntervalo(List<Produto> lista) {
		System.out.println("Insira o valor mínimo que o produto pode ter");
		float menorValor = scan.nextFloat();
		System.out.println("Insira o valor máximo que o produto pode ter");
		float maiorValor = scan.nextFloat();
		for (Produto produto : lista) {
			if(produto.getPreco() <= maiorValor && produto.getPreco() >= menorValor) {
				System.out.println("Identificador único:"  + produto.getIdentificador());
				System.out.println("Nome do produto: " + produto.getNome());
				System.out.println("Preço do produto: " + produto.getPreco());
				System.out.println("Tipo do produto: " + produto.getTipo().nome);
				System.out.println("Quantidade no estoque: " + produto.getEstoque());
				System.out.println("======================================");
			}
		}
	}

	public void removerProduto(List<Produto> lista) {
		lista.forEach(n -> System.out.println(n.getIdentificador() + "   " + n));
		 System.out.println("Digite o indíce que deseja remover:");
		int indice = scan.nextInt();
		lista.remove(indice - 1);
		this.imprimirProdutos(lista);
	}
	public Produto editarProduto(List<Produto> lista) {
		this.imprimirProdutos(lista);
		System.out.println("Qual produto deseja editar?");
		int indice = scan.nextInt();
		System.out.println("Digite o novo nome do produto:");
		String nomeProduto = scan.next();
		System.out.println("Digite o novo preço do produto:");
		float preco = scan.nextFloat();
		System.out.println("Digite o novo estoque:");
		int estoque = scan.nextInt();
		System.out.println("Digite o novo tipo do produto:");
		for(TipoProduto produtoA : TipoProduto.values()) {
				System.out.println(produtoA.ordinal() + "- " + produtoA.getNome());
			}
			TipoProduto a = (TipoProduto.values()[Integer.parseInt(scan.next())]);
			Produto produto = new Produto(nomeProduto, preco, estoque, a);
			produto.setIdentificador(indice);
		return lista.set(indice-1, produto);
	}
	
	public void inserirProduto(List<Produto> lista) {
		System.out.println("Insira o nome do produto:");
		String name = scan.next();
		System.out.println("Insira o preço do produto: ");
		float preco = scan.nextFloat();
		for(TipoProduto tipo : TipoProduto.values()) {
			System.out.println(tipo.getId() + "    "   + tipo.getNome());
		}
		System.out.println("Insira o numero do tipo do produto: " );
		int tipo = Integer.parseInt(scan.next());
		System.out.println("Insira a quantidade em estoque do produto: " );
		int estoque = Integer.parseInt(scan.next());
		
		Produto produto = new Produto(name, preco, estoque, TipoProduto.values()[tipo - 1]);
		lista.add(produto);
		System.out.println("======================================");
	}

}
