
public class Administrador extends Funcionario{

	private String senha;
	

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean funcaoAdministrativaBiblioteca(){
		return true;
	}
}
