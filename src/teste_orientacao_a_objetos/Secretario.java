package teste_orientacao_a_objetos;

import java.time.YearMonth;

public class Secretario extends Funcionario {

	public Secretario(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	private static float salario = 7000;
	private static float bonus = 1000;
	private static float beneficio = 0.2f;
	
	public void setSalario(float salario) {
		Secretario.salario = salario;
	}
	
	public void setBonus(float bonus) {
		Secretario.bonus = bonus;
	}
	
	public void setBeneficio(float beneficio) {
		Secretario.beneficio = beneficio;
	}
	
	public float getSalario() {
		return Secretario.salario;
	}
	
	public float getBonus() {
		return Secretario.bonus;
	}
	
	public float getBeneficio() {
		return Secretario.beneficio;
	}
	
}
