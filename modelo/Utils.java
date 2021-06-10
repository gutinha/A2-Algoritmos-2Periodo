package modelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {
	static Scanner scan = new Scanner(System.in);
	
	public static void menuUsuario(List<Produto> lista, UsuarioGeral user) {
		int opcao = 0;
		do {
			System.out.println("Insira o que você deseja fazer");
			System.out.println("1-Imprimir todos os produtos");
			System.out.println("2-Sair do programa");
			opcao = scan.nextInt();
			if(opcao == 1){
				user.imprimirProdutos(lista);
			} else if(opcao == 2){
				System.out.println("Saindo do programa e imprimindo a lista...");
				user.imprimirProdutos(lista);
				System.exit(0);
			}
		} while (opcao != 2);
	}
	
	public static void menuAdmin(List<Produto> lista, UsuarioAdministrativo admin) {
		int escolha = 0;
		do {
			System.out.println("Insira o que você deseja fazer");
			System.out.println("1-Inserir produto no estoque");
			System.out.println("2-Editar um produto do estoque");
			System.out.println("3-Remover produto do estoque");
			System.out.println("4-Ver os produtos do estoque");
			System.out.println("5-Ver os produtos do estoque, filtrando por tipo de produto");
			System.out.println("6-Ver os produtos do estoque, filtrando por intervalo de preço");
			System.out.println("7-Sair do programa");
			escolha = scan.nextInt();
			switch(escolha) {
			case 1:
				admin.inserirProduto(lista);
				admin.imprimirProdutos(lista);
				break;
			case 2:
				admin.editarProduto(lista);
				admin.imprimirProdutos(lista);
				break;
			case 3:
				admin.removerProduto(lista);
				break;
			case 4:
				admin.imprimirProdutos(lista);
				break;
			case 5:
				admin.imprimirProdutosPorTipo(lista);
				break;
			case 6:
				admin.imprimirProdutosPorIntervalo(lista);
				break;
			default:
				System.out.println("Saindo do programa e imprimindo a lista....");
				admin.imprimirProdutos(lista);
				break;
			}
		} while (escolha != 7);
	}
	

	public static void menu() {
		
		List<Produto> lista = new ArrayList<Produto>();
		
		//Carga de dados
		Produto produto1 = new Produto("Arroz", 5.45f, 22,  TipoProduto.GRAO);
		Produto produto2 = new Produto("Frango", 14.45f, 22,  TipoProduto.CONGELADO);
		Produto produto3 = new Produto("Leite", 20.45f, 22,  TipoProduto.FRIO);
		Produto produto4 = new Produto("Melancia", 15.00f, 22,  TipoProduto.HORTIFRUTI);
		Produto produto5 = new Produto("Skol", 22.45f, 22,  TipoProduto.BEBIDA);
		Produto produto6 = new Produto("Feijão", 11.45f, 22,  TipoProduto.GRAO);
		Produto produto7 = new Produto("Queijo", 8.45f, 22,  TipoProduto.FRIO);
		Produto produto8 = new Produto("Pão Francês", 0.45f, 22,  TipoProduto.PADARIA);
		Produto produto9 = new Produto("Sabão em pó", 2.45f, 22,  TipoProduto.LIMPEZA);
		Produto produto10 = new Produto("Detergente", 8.35f, 50,  TipoProduto.LIMPEZA);
		Produto produto11 = new Produto("Pastel de flango", 5.0f, 10,  TipoProduto.PADARIA);
		lista.add(produto1);
		lista.add(produto2);
		lista.add(produto3);
		lista.add(produto4);
		lista.add(produto5);
		lista.add(produto6);
		lista.add(produto7);
		lista.add(produto8);
		lista.add(produto9);
		lista.add(produto10);
		lista.add(produto11);
		
		//Instanciando usuários
		UsuarioAdministrativo admin = new UsuarioAdministrativo("Admin", "Admin");
		UsuarioGeral user = new UsuarioGeral("user", "user");
		
		//Menu
		int opcao=0;
		while(opcao==0) {
		System.out.println("Insira o tipo de usuário: \n1- Usuário \n2- Administrador");
			try {
			opcao = scan.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Você não digitou um número, tente novamente.");
				scan = new Scanner(System.in);
			}
			}
		if(opcao == 1) {
			String loginu = "---";
			String senhau = "---";
			while(!loginu.equals(user.getUsuario()) || !senhau.equals(user.getSenha())){
				System.out.println("Digite o login do usuário:");
					loginu = scan.next();
					System.out.println("Digite a senha do usuário:");
					senhau = scan.next();
			if(!loginu.equals(user.getUsuario()) || !senhau.equals(user.getSenha())) {
						System.out.println("Login ou senha incorreta. Tente novamente");
					}
			}
			if(loginu.equals(user.getUsuario()) && senhau.equals(user.getSenha())){
					menuUsuario(lista, user);
					}
		}
		else if(opcao == 2) {
				String login= "-";
				String senha = "-";
				while (!login.equals(admin.getUsuario()) || !senha.equals(admin.getSenha())){
					System.out.println("Digite o login do administrador:");
					login = scan.next();
					System.out.println("Digite a senha do administrador:");
					senha = scan.next();
					if(!login.equals(admin.getUsuario()) || !senha.equals(admin.getSenha())) {
						System.out.println("Login ou senha incorreta. Tente novamente");
					}
					
					if(login.equals(admin.getUsuario()) && senha.equals(admin.getSenha())) {
						menuAdmin(lista,admin);
					}
				}
				
				
			}else {
				System.out.println("Finalizando");
			}
		scan.close();
	}
	
	
}
