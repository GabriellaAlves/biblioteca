public class Curso {

	private String nome;
	private String codigo;

	public Curso(String nomeCurso, String codigo) {
		this.setNome(nomeCurso);
		this.setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
