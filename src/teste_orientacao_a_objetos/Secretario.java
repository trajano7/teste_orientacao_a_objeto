package teste_orientacao_a_objetos;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Secretario extends Funcionario {

	public Secretario(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	private static float salarioBase = 7000;
	private static float bonus = 1000;
	private static float beneficio = 0.2f;
	
	public float getSalario(YearMonth data) {
		long anosDeServico = this.contratacao.until(data, ChronoUnit.YEARS);
		return anosDeServico >= 0 ? Secretario.salarioBase + Secretario.bonus*anosDeServico : 0;
	}
	
	
	public float getBeneficio(YearMonth data) {
		return Secretario.beneficio*this.getSalario(data);
	}
	
}
