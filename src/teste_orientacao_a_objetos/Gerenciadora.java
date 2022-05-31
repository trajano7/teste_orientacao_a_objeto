package teste_orientacao_a_objetos;

import java.util.ArrayList;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Gerenciadora {

//	private ArrayList<Funcionario> funcionarios = new ArrayList<>();
//	
//	public Gerenciadora(ArrayList<Funcionario> funcionarios) {
//		this.funcionarios = funcionarios;
//	}
//	
//	public void gerenciar() {
//		this.valorTotalSB();
//	}
	
	private float calcularVendas(ArrayList<Venda> listaDeVendas) {
		float totalDeVendas = 0;
		
		for(Venda venda : listaDeVendas) {
		   totalDeVendas += venda.getValorDaVenda();
		}
		
		return totalDeVendas;
	}
	
	public float valorTotalSB(ArrayList<Funcionario> funcionarios) {
		float montante = 0;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionarios) {
			
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getContratacao().toString());
			System.out.println(funcionario.contratacao.until(YearMonth.now(), ChronoUnit.YEARS));
			
			anosDeServico = funcionario.contratacao.until(YearMonth.now(), ChronoUnit.YEARS);
			
//			funcionario.contratacao.
			
			if (funcionario instanceof Secretario) {
				montante += Secretario.getSalario();
				montante += Secretario.getBonus()*anosDeServico;
			
			}
			else if (funcionario instanceof Vendedor) {
				montante += Vendedor.getSalario();
				montante += Vendedor.getBonus()*anosDeServico;
				montante += calcularVendas(((Vendedor)(funcionario)).getListaDeVendas());
			}
			
		}
		
		
		
		return 50;
	}
	
	
	
	
}
