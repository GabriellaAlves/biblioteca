
import java.util.ArrayList;
import java.util.List;

public class GerentePessoa {

	boolean usuarioFuncionario = true;
	
	
	// aluno/professor/funcionario
	
	List<Aluno> listaAluno = new ArrayList<Aluno>();
	List<Professor> listaProfessor = new ArrayList<Professor>();
	List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
	List<Administrador> listaAdministrador = new ArrayList<Administrador>();
	
	
	Administrador usuarioLogado = null;
	
	public Administrador getUsuarioLogado() {
		return usuarioLogado;
	}

	public void login(String cpf, String senha) {
		for (Administrador p : listaAdministrador) {
				if (p.getCpf().equals(cpf) && (p.getSenha().equals(senha)))
						usuarioLogado = p;
				return;
			}
		throw new Excecao("O usuário não tem cadastro");
	}

	public void addAdministrador(Administrador admin){
		listaAdministrador.add(admin);
	}
	
	public void deleteAdministrador(Administrador admin){
		retornarAdministrador(admin.getCpf());
		listaAdministrador.remove(admin);	
	}
	
	public Administrador retornarAdministrador(String cpf) {
		for(Administrador admin: listaAdministrador){
			if(admin.getCpf().equals(cpf));
				return admin;
		}
		throw new Excecao("Não existe administrador com este cpf");
	}
	
	
	
	public void addAluno(Aluno aluno){
			isExisteAluno(aluno.getCpf());
			listaAluno.add(aluno);	
	}
	
	public void deleteAluno(Aluno aluno) {
			retornarAluno(aluno.getCpf());
			listaAluno.remove(aluno);	
	}
		
	public Aluno retornarAluno(String cpf) {
		for(Aluno aluno: listaAluno){
			if(aluno.getCpf().equals(cpf));
				return aluno;
		}
		throw new Excecao("Não existe aluno com este cpf");
	}
	
	public Aluno alterarDadosAluno(Aluno aluno){
		for (Aluno a : listaAluno){
				if(aluno.getCpf().equals(a.getCpf())){
					a=aluno;
					listaAluno.add(a);
					return a;
				}
			}
		throw new Excecao("Não existe aluno com este cpf");
	}
	
	
	public void addFuncionario(Funcionario funcionario) {
			isExisteFuncionario(funcionario.getCpf());
			listaFuncionario.add(funcionario);	
	}
	
	public void deleteFuncionario(Funcionario funcionario) {
			retornarFuncionario(funcionario.getCpf());
			listaAluno.remove(funcionario);	
	}
	
	public Funcionario retornarFuncionario(String cpfFuncionario) {
		for(Funcionario funcionario: listaFuncionario){
			if(funcionario.getCpf().equals(cpfFuncionario))
				return funcionario;
		}
		throw new Excecao("Não existe funcionario com este cpf");
	}
		
	public Funcionario alterarDadosFuncionario(Funcionario funcionario){
		for (Funcionario func : listaFuncionario){
				if(funcionario.getCpf().equals(func.getCpf())){
					func=funcionario;
					listaFuncionario.add(func);
					return func;
				}
			}
		throw new Excecao("Não existe funcionairo com este cpf");
	}
	
	
	public void addProfessor(Professor professor) {
			isExisteProfessor(professor.getCpf());
			listaProfessor.add(professor);	
	}

	public void deleteProfessor(Professor professor) {
			retornarProfessor(professor.getCpf());
			listaAluno.remove(professor);	
	}
	
	public Professor retornarProfessor(String cpfProfessor) {
		for(Professor professor: listaProfessor){
			if(professor.getCpf().equals(cpfProfessor));
				return professor;
		}
		throw new Excecao("Não existe professor com este cpf");
	}
	
	public Professor alterarDadosProfessor(Professor professor){
		for (Professor prof: listaProfessor){
				if(professor.getCpf().equals(prof.getCpf())){
					prof=professor;
					listaProfessor.add(prof);
					return prof;
				}
			}
		throw new Excecao("Não existe professor com este cpf");
		}
	
	

	public boolean campoCPFNaoPreenchido(){
		return true;
	}
	
	//gambiarra
	public boolean cpfvalido(String cpf){
		if(cpf.length()==15){
			return true;
		}else{
			return false;
		}
	}
	
		
	public void isExisteAluno(String cpf){
		for(Aluno aluno: listaAluno){
			if(aluno.getCpf().equals(cpf))
				throw new Excecao("Aluno já existente"); 
		}
	}
	
	private void isExisteProfessor(String cpfProfessor){
		for(Professor professor: listaProfessor){
			if(professor.getCpf().equals(cpfProfessor))
				throw new Excecao("Professor não existente"); 
		}
	}
	
	private void isExisteFuncionario(String cpfFuncionario){
		for(Funcionario funcionario: listaFuncionario){
			if(funcionario.getCpf().equals(cpfFuncionario))
				throw new Excecao("Funcionário já existente"); 
		}
	}
	
}
