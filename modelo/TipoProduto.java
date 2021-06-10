package modelo;

public enum TipoProduto {
	GRAO("Grão", 1), CONGELADO("Congelado",2), FRIO("Frio",3), HORTIFRUTI("Hortifruti",4), PADARIA("Padaria",5), BEBIDA("Bebida",6),LIMPEZA("Limpeza",7);
	
	String nome;
	int id;
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}


	TipoProduto(String _nome, int _id){
		this.nome = _nome;
		this.id = _id;
	}
}
