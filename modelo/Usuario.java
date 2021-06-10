package modelo;
import java.util.List;
public abstract class Usuario {
	private String usuario;
	private String senha;
	
	Usuario(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract void imprimirProdutos(List<Produto> lista);
}
