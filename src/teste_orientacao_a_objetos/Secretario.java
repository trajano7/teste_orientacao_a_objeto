package teste_orientacao_a_objetos;

import java.time.YearMonth;

public class Secretario extends Funcionario {

	public Secretario(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	static float salario = 7000;
	static float bonus = 1000;
	static float beneficio = 0.2f;
	
	public static void setSalario(float salario) {
		Secretario.salario = salario;
	}
	
	public static void setBonus(float bonus) {
		Secretario.bonus = bonus;
	}
	
	public static void setBeneficio(float beneficio) {
		Secretario.beneficio = beneficio;
	}
	
	public static float getSalario() {
		return Secretario.salario;
	}
	
	public static float getBonus() {
		return Secretario.bonus;
	}
	
	public static float getBeneficio() {
		return Secretario.beneficio;
	}
	
}
