import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class BibliotecaTest {
	Biblioteca fachada;
			
		@Before
		public void criarFacadaBiblioteca(){
			 fachada = new Biblioteca();	
		}
		
		@Test 
		public void addAdministrador(){
			Administrador admin = criarAdministrador();
			fachada.addAdministrador(admin);
					
			Assert.assertEquals(admin, fachada.retornarAdministrador("876.765.098-66"));
		}
		
		@Test(expected=Excecao.class)
		public void AdministradorSemCadastroTentaLogar(){
			Administrador admin = new Administrador();
			fachada.login(admin.getCpf(), admin.getSenha());						
		}
		
		@Test
		public void logarAdministrador(){ 
			criaCadastroELogaAdministrador();
			
			Assert.assertTrue(true);		
		}
		
		@Test 
		public void addAluno() {
			criaCadastroELogaAdministrador();
			
			Aluno a = criarAluno();
			fachada.addAluno(a);
			Assert.assertEquals(a, fachada.retornarAluno("123.444.345-12"));		
		}
		
		@Test(expected=Excecao.class)
		public void addAlunoNovamente(){
			criaCadastroELogaAdministrador();
			
			Aluno a = criarAluno();
			fachada.addAluno(a);
			fachada.addAluno(a);			
		}
		
		@Test
		public void deletarAluno(){
			criaCadastroELogaAdministrador(); 	
			
			Aluno a = criarAluno();
			fachada.addAluno(a);
			Assert.assertEquals(a, fachada.retornarAluno("123.444.345-12"));
			
			fachada.deleteAluno(a);
			Assert.assertTrue(true);//removeu Aluno
		}
		
		@Test (expected=Excecao.class)
		public void excluirAlunoNaoExistente() {
			criaCadastroELogaAdministrador();
			
			Aluno alun = new Aluno();
			fachada.deleteAluno(alun);
			Assert.assertEquals(alun, fachada.retornarAluno("123.432.212-00"));//não existe funcionario para remover
		}
		
		@Test
		public void alterarAluno(){
			criaCadastroELogaAdministrador();
			
			Aluno a = criarAluno();
			fachada.addAluno(a);
			fachada.alterarDadosAluno(a);
			Assert.assertEquals(a, fachada.retornarAluno("123.444.345-12"));
		}
		
		@Test 
		public void AddAlunoCPFInvalido(){
			criaCadastroELogaAdministrador();
			
			Aluno aluno = new Aluno();
			aluno.setNome("Joao");
			aluno.setMatricula("80809912");
			aluno.setCpf("12323");
			aluno.setTelefone("87234567");
			aluno.setCurso("LCC", "123");
			fachada.addAluno(aluno);
			Assert.assertFalse(false);
		}
			
		@Test
		public void addAlunoSemCPF(){ //MOSTRAR PARA VER SE ESTAR CORRETO
			criaCadastroELogaAdministrador();
			Aluno aluno = new Aluno();
			aluno.setNome("Joao");
			aluno.setMatricula("80809912");
			aluno.setCpf(null);
			aluno.setTelefone("87234567");
			aluno.setCurso("LCC", "123");
			fachada.addAluno(aluno);
			fachada.campoCPFNaoPreenchido();
			Assert.assertTrue(true);
		}
		
		@Test
		public void addFuncionario(){
			criaCadastroELogaAdministrador();
			
			Funcionario f = criarFuncionario();
			fachada.addFuncionario(f);
			Assert.assertEquals(f, fachada.retornarFuncionario("123.472.123-09"));
		}
		
		@Test 
		public void excluirFuncionario(){
			criaCadastroELogaAdministrador();
			
			Funcionario f = criarFuncionario();
			fachada.addFuncionario(f);
			fachada.deleteFuncionario(f);
			Assert.assertEquals(f, fachada.retornarFuncionario("123.472.123-09"));
			Assert.assertTrue(true);
		}
		
		@Test
		public void excluirFuncionarioNovamente(){//OLHAR
			criaCadastroELogaAdministrador();
			
			Funcionario f = criarFuncionario();
			fachada.addFuncionario(f);
			Assert.assertEquals(f, fachada.retornarFuncionario("123.472.123-09"));	
			
			fachada.deleteFuncionario(f);
			fachada.deleteFuncionario(f);
			Assert.assertFalse(false);
			
		}
			
		@Test(expected=Excecao.class)
		public void excluirFuncionarioNaoExistente() {
			criaCadastroELogaAdministrador();
			
			Funcionario f = criarFuncionario();
			fachada.addFuncionario(f);
			Assert.assertEquals(f, fachada.retornarFuncionario("123.472.123-09"));
			
			Funcionario func = new Funcionario();
			fachada.deleteFuncionario(func);
			
		}
		
		@Test
		public void alterarFuncionario(){
			criaCadastroELogaAdministrador();
			
			Funcionario funcionario = criarFuncionario();
			fachada.addFuncionario(funcionario);
			Assert.assertEquals(funcionario, fachada.retornarFuncionario("123.472.123-09"));
			
			fachada.alterarDadosFuncionario(funcionario);
			Assert.assertEquals(funcionario, fachada.retornarFuncionario("123.472.123-09"));
		}
		
		@Test
		public void addProfessor() {
			criaCadastroELogaAdministrador();
			
			Professor p = criarProfessor();
			fachada.addProfessor(p);
			Assert.assertEquals(p, fachada.retornarProfessor("123.468.987-56"));
		}
		
		@Test
		public void excluirProfessor() {
			criaCadastroELogaAdministrador();
			
			Professor p = criarProfessor();
			fachada.addProfessor(p);
				
			fachada.deleteProfessor(p);
			Assert.assertEquals(p, fachada.retornarProfessor("123.468.987-56"));//removeu professor
		}
		
		@Test(expected=Excecao.class)
		public void excluirProfessornaoExistente() {
			criaCadastroELogaAdministrador();
			
			Professor w = new Professor();
			fachada.deleteProfessor(w);//removeu professor
		}

		
		
		
		public Aluno criarAluno(){
			 Aluno aluno = new Aluno();
			 aluno.setNome("Joao");
			 aluno.setMatricula("80809912");
			 aluno.setCpf("123.444.345-12");
			 aluno.setTelefone("87234567");
			 aluno.setCurso("LCC", "123");	
			 return aluno;
		}
		
		public Professor criarProfessor(){
			 Professor professor = new Professor();
			 professor.setNome("Joao");
			 professor.setMatricula("80809912");
			 professor.setCpf("123.468.987-56");
			 professor.setTelefone("87234567");
			 professor.setDepartamento("Exatas");	
			 return professor;
		}
		
		public Funcionario criarFuncionario(){
			 Funcionario funcionario = new Funcionario();
			 funcionario.setNome("Joao");
			 funcionario.setMatricula("80809912");
			 funcionario.setCpf("123.472.123-09");
			 funcionario.setTelefone("87234567");
			 funcionario.setSetor("Coordenação");	
			 return funcionario;
		}
		
		private Administrador criarAdministrador() {
			Administrador admin = new Administrador();
			admin.setNome("Joao");
			admin.setMatricula("80809912");
			admin.setCpf("876.765.098-66");
			admin.setTelefone("87234567");
			admin.setSetor("Biblioteca");
			admin.setSenha("12345");
				return admin;
		}
		
		private void criaCadastroELogaAdministrador(){
			Administrador admin = criarAdministrador();
			
			fachada.addAdministrador(admin);
			fachada.login(admin.getCpf(), admin.getSenha());
		}
}

