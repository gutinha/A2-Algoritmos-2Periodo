package modelo;

public class Produto {
	private int identificador;
	private String nome;
	private float preco;
	private int estoque;
	private TipoProduto tipo;
	
	private static int control = 0;
	Produto(String _nome, float _preco, int _estoque, TipoProduto _tipoProduto){
		this.setNome(_nome);
		this.setPreco(_preco);
		this.setEstoque(_estoque);
		this.setTipo(_tipoProduto);
		this.setIdentificador(this.identificadorGlobal());
	}
	
	@Override
	public String toString() {
		return this.getNome() + this.getEstoque() + this.getPreco() + this.getTipo().nome;
	}
	
	public int identificadorGlobal() {
		control += 1;
		return control;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	public static int getControl() {
		return control;
	}

	public static void setControl(int control) {
		Produto.control = control;
	}
	
}
