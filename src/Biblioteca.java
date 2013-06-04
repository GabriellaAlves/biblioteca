

public class Biblioteca{

	GerentePessoa gp = new GerentePessoa();
	
	//Dados para o Administrador
	public void login(String cpf, String senha) {
		gp.login(cpf, senha);
	}
		
	public void addAdministrador(Administrador admin) {
		gp.addAdministrador(admin);
	}
	
	public void deleteAdministrador(Administrador admin) {
		gp.deleteAdministrador(admin);
	}
	
	public Administrador retornarAdministrador(String cpfAdmin) {
		return gp.retornarAdministrador(cpfAdmin);
	}
	
	//Dados para o aluno -usuário
	public void addAluno(Aluno aluno) {
		gp.addAluno(aluno);
	}
	
	public void deleteAluno(Aluno aluno){
		gp.deleteAluno(aluno);
	}
	
	public Aluno retornarAluno(String cpfAluno) {
		return gp.retornarAluno(cpfAluno);
	}
	
	public Aluno alterarDadosAluno(Aluno aluno){
		return gp.alterarDadosAluno(aluno);
	}

	//Dados para o funcionário - usuário
		
	public void addFuncionario(Funcionario funcionario) {
		gp.addFuncionario(funcionario);
	}

	public void deleteFuncionario(Funcionario funcionario) {
		gp.deleteFuncionario(funcionario);
	}
	
	public Funcionario retornarFuncionario(String cpfFuncionario) {
		return gp.retornarFuncionario(cpfFuncionario);
	}

	public Funcionario alterarDadosFuncionario(Funcionario funcionario) {
		return gp.alterarDadosFuncionario(funcionario);
	}

	//Dados do professor
	public void addProfessor(Professor professor) {
		gp.addProfessor(professor);
	}
	
	public void deleteProfessor(Professor professor) {
		gp.deleteProfessor(professor);
	}
		
	public Professor retornarProfessor(String cpfProfessor) {
		return gp.retornarProfessor(cpfProfessor);
	}
	
	public Professor alterarDadosProfessor(Professor professor) {
		return gp.alterarDadosProfessor(professor);
	
	}

	
	
	
	/*
	public void pegarLivro(String cpf, List<String> refLivros) {
		
		try {
			gl.pegarLivro(gp.retornarAluno(cpf), refLivros);
		} catch (LivroAlugado e) {
			e.printStackTrace();
		} catch (AlugoNaoPodeAlugar e) {
			e.printStackTrace();
		}
	}

	
	public void addLivro(String autor, String refLivro, String editora) {
		gl.addLivro(autor,refLivro,editora);	
	}

	
	public String livrosAlugadosPorAluno(String cpf) {
		return gl.livrosAlugadosPorAluno(retornarAluno(cpf));
	}
	*/
	public boolean campoCPFNaoPreenchido(){
		return gp.campoCPFNaoPreenchido();
	}
	
	//gambiarra
	public boolean cpfvalido(String cpf){
		return gp.cpfvalido(cpf);
}


	
}
