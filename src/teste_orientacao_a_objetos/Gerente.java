package teste_orientacao_a_objetos;
import java.time.YearMonth;


public class Gerente extends Funcionario {
	public Gerente(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	static float salario = 20000;
	static float bonus = 3000;
	
	public static void setSalario(float salario) {
		Gerente.salario = salario;
	}
	
	public static void setBonus(float bonus) {
		Gerente.bonus = bonus;
	}
		
	public static float getSalario() {
		return Gerente.salario;
	}
	
	public static float getBonus() {
		return Gerente.bonus;
	}
	
	
}
