package teste_orientacao_a_objetos;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Vendedor extends Funcionario {

	public Vendedor(String nome, YearMonth contratacao, ArrayList<Venda> vendas) {
		super(nome, contratacao);
		this.listaDeVendas = vendas;
	}
	
	private static float salarioBase = 12000;
	private static float bonus = 1800;
	private static float beneficio = 0.3f;
	private ArrayList<Venda> listaDeVendas;
	
	public float getSalario(YearMonth data) {
		long anosDeServico = this.contratacao.until(data, ChronoUnit.YEARS);
		return anosDeServico >= 0 ? Vendedor.salarioBase + Vendedor.bonus*anosDeServico : 0;
	}
	
	public float getBeneficio(YearMonth data) {
		float valorEmVendas = getValorDeVendas(data);
		return Vendedor.beneficio*valorEmVendas;
	}
	
	public ArrayList<Venda> getListaDeVendas() {
		return listaDeVendas;
	}
	
	//Procura e retorna o valor em vendas de um vendedor em um determinado mes
	public float getValorDeVendas(YearMonth data) {
		
		for(Venda venda : this.listaDeVendas) {
		   if (venda.dataDaVenda.equals(data)) {
			  return venda.getValorDaVenda(); 
		   }
		}
		
		return 0;
	}
	
}

class Venda {
	
	YearMonth dataDaVenda;
	float valorDaVenda;
	
	public Venda(YearMonth dataDaVenda, float valorDaVenda) {
		this.dataDaVenda = dataDaVenda;
		this.valorDaVenda = valorDaVenda;
	}
	
	YearMonth getDataDaVenda() {
		return this.dataDaVenda;
	}
	
	float getValorDaVenda() {
		return this.valorDaVenda;
	}
	
	
}
