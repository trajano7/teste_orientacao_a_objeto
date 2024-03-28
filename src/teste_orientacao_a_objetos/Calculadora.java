package teste_orientacao_a_objetos;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;

public class Calculadora {
	
	//Metodo responsavel por calcular o valor total pago em salarios e beneficios em um determinado mes de um determinado ano,
	//dado uma lista de funcionarios
	public float getTotalPago(ArrayList<Funcionario> funcionarios, YearMonth data) {
		float montante = 0;
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");    
        //String dataFormatada = data.format(formatter);
		
		for(Funcionario funcionario : funcionarios) {
			
			// Debug print
			/*
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de Contratacao: " + funcionario.getContratacao().toString());
			System.out.println("Anos de Servico até " + dataFormatada +  ": " + funcionario.contratacao.until(data, ChronoUnit.YEARS));
			System.out.println("");	
			*/
			
			montante += funcionario.getSalario(data);
			montante += funcionario.getBeneficio(data);
				
		}
			
		return montante;
	}
	
	//Metodo responsavel por calcular o valor total pago em salarios
	public float getTotalSalario(ArrayList<Funcionario> funcionarios, YearMonth data) {
		float montante = 0;
		
		for(Funcionario funcionario : funcionarios) {
			montante += funcionario.getSalario(data);
		}
		
		return montante;
		
	}
	
	//Metodo responsavel por o valor total pago em beneficios
	public float getTotalBeneficio(ArrayList<Funcionario> funcionariosComBenefico, YearMonth data) {
		float montante = 0;
		
		for(Funcionario funcionario : funcionariosComBenefico) {	
			montante += funcionario.getBeneficio(data);
		}

		return montante;
	}
	
	//Metodo responsavel por achar o funcionario mais bem pago
	public String getMelhorPago(ArrayList<Funcionario> funcionarios, YearMonth data) {
		String funcionarioMaisPago = "";
		float valorGanho = 0, valorMaisAlto = 0;
		
		for(Funcionario funcionario : funcionarios) {
				
			valorGanho += funcionario.getSalario(data);
			valorGanho += funcionario.getBeneficio(data);
			
			if (valorGanho >= valorMaisAlto) {
				valorMaisAlto = valorGanho;
				funcionarioMaisPago = funcionario.getNome();
			}
			
			valorGanho = 0;
			
		}
				
			if (valorMaisAlto == 0) {
				return "Não há registro de nenhum funcionario contratado nesta data.";
			}
			return funcionarioMaisPago;
	}
	
	//Metodo responsavel por achar o funcionario que recebeu o maior beneficio em um determinado mes de um determinado ano
	public String getMelhorBeneficiado(ArrayList<Funcionario> funcionariosComBenefico, YearMonth data) {
		String funcionarioMaisPago = "";
		float beneficio = 0, beneficioMaisAlto = 0;
		
		for(Funcionario funcionario : funcionariosComBenefico) {
			
			beneficio = funcionario.getBeneficio(data);
			
			if (beneficio >= beneficioMaisAlto) {
				beneficioMaisAlto = beneficio;
				funcionarioMaisPago = funcionario.getNome();
			}
			
		}
		
		if (beneficioMaisAlto == 0) {
			return "Não há registro de nenhum funcionario contratado nesta data.";
		}
		return funcionarioMaisPago;
	}
	
	//Metodo responsavel por achar o melhor vendedor
	public String getMelhorVendedor(ArrayList<Funcionario> funcionarios, YearMonth data) {
		String melhorVendedor = "";
		float valorEmVendas, valorMaisAlto = 0;
		
		for(Funcionario funcionario : funcionarios) {
			
			valorEmVendas = ((Vendedor) funcionario).getValorDeVendas(data);
			
			if (valorEmVendas >= valorMaisAlto) {
				valorMaisAlto = valorEmVendas;
				melhorVendedor = funcionario.getNome();
			}
			
		}
		
		if (valorMaisAlto == 0) {
			return "Não há registro de nenhum vendedor contratado nesta data ou não houve nenhuma venda.";
		}
		return melhorVendedor;
	}
		
	
	
	
	
}
