package teste_orientacao_a_objetos;
import java.time.YearMonth;


public class Gerente extends Funcionario {
	public Gerente(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	private static float salario = 20000;
	private static float bonus = 3000;
	private static float beneficio = 0;
	
	public void setSalario(float salario) {
		Gerente.salario = salario;
	}
	
	public void setBonus(float bonus) {
		Gerente.bonus = bonus;
	}
		
	public void setBeneficio(float beneficio) {
		Gerente.beneficio = beneficio;	
	}
	
	public float getSalario() {
		return Gerente.salario;
	}
	
	public float getBonus() {
		return Gerente.bonus;
	}


	public float getBeneficio() {
		return Gerente.beneficio;
	}
	
	
}
