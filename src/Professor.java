public class Professor extends Pessoa {

	private Departamento departamento;
	

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = new Departamento(departamento);
	}

	
}
