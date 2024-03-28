package teste_orientacao_a_objetos;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;


public class Gerente extends Funcionario {
	public Gerente(String nome, YearMonth contratacao) {
		super(nome, contratacao);
	}
	
	private static float salarioBase = 20000;
	private static float bonus = 3000;
	private static float beneficio = 0;
	
	public float getSalario(YearMonth data) {
		long anosDeServico = this.contratacao.until(data, ChronoUnit.YEARS);
		return anosDeServico >= 0 ? Gerente.salarioBase + Gerente.bonus*anosDeServico : 0;
	}
	
	public float getBeneficio(YearMonth data) {
		return beneficio;
	}
}
