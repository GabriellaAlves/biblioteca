
public class Aluno extends Pessoa{

	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(String nome, String codigo ) {
		this.curso = new Curso(nome, codigo);
	}

}
