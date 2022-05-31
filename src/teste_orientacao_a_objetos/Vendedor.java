package teste_orientacao_a_objetos;

import java.time.YearMonth;
import java.util.ArrayList;

public class Vendedor extends Funcionario {

	public Vendedor(String nome, YearMonth contratacao, ArrayList<Venda> vendas) {
		super(nome, contratacao);
		this.listaDeVendas = vendas;
	}
	
	private static float salario = 12000;
	private static float bonus = 1800;
	private static float beneficio = 0.3f;
	private ArrayList<Venda> listaDeVendas;
	
	public void setSalario(float salario) {
		Vendedor.salario = salario;
	}
	
	public void setBonus(float bonus) {
		Vendedor.bonus = bonus;
	}
	
	public void setBeneficio(float beneficio) {
		Vendedor.beneficio = beneficio;
	}
	
	public float getSalario() {
		return Vendedor.salario;
	}
	
	public float getBonus() {
		return Vendedor.bonus;
	}
	
	public float getBeneficio() {
		return Vendedor.beneficio;
	}
	
	public ArrayList<Venda> getListaDeVendas() {
		return listaDeVendas;
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
