package teste_orientacao_a_objetos;

import java.time.YearMonth;
import java.util.ArrayList;

public class Vendedor extends Funcionario {

	public Vendedor(String nome, YearMonth contratacao, ArrayList<Venda> vendas) {
		super(nome, contratacao);
		this.listaDeVendas = vendas;
	}
	
	static float salario = 12000;
	static float bonus = 1800;
	static float beneficio = 0.3f;
	ArrayList<Venda> listaDeVendas;
	
	public static void setSalario(float salario) {
		Vendedor.salario = salario;
	}
	
	public static void setBonus(float bonus) {
		Vendedor.bonus = bonus;
	}
	
	public static void setBeneficio(float beneficio) {
		Vendedor.beneficio = beneficio;
	}
	
	public static float getSalario() {
		return Vendedor.salario;
	}
	
	public static float getBonus() {
		return Vendedor.bonus;
	}
	
	public static float getBeneficio() {
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
