package teste_orientacao_a_objetos;

import java.util.ArrayList;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Calculadora {
	
	//Procura e retorna a venda de um vendedor em um dado mes
	private float calcularBeneficioDeVendas(ArrayList<Venda> listaDeVendas, YearMonth data) {
		
		for(Venda venda : listaDeVendas) {
		   if (venda.dataDaVenda.equals(data)) {
			  return venda.getValorDaVenda(); 
		   }
		}
		
		return 0;
	}
	
	//Metodo responsavel por calcular o valor total pago em salários e beneficios
	public float valorTotalSB(ArrayList<Funcionario> funcionarios, YearMonth data) {
		float montante = 0, beneficio, valorEmVendas, salario;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionarios) {
			
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getContratacao().toString());
			System.out.println(funcionario.contratacao.until(YearMonth.now(), ChronoUnit.YEARS));
			
			anosDeServico = funcionario.contratacao.until(data, ChronoUnit.YEARS);
			
			salario = funcionario.getSalario() + funcionario.getBonus()*anosDeServico;
			montante += salario;
			beneficio = funcionario.getBeneficio();
			
			if (funcionario instanceof Secretario) {
				montante += beneficio*salario;
			}
			else if (funcionario instanceof Vendedor) {
				valorEmVendas = calcularBeneficioDeVendas(((Vendedor)(funcionario)).getListaDeVendas(),data);
				montante += valorEmVendas*beneficio;
			}	
		}
		
		System.out.println(montante);
			
		return montante;
	}
	
	//Metodo responsavel por calcular o valor total pago em salarios
	public float valorTotalS(ArrayList<Funcionario> funcionarios, YearMonth data) {
		float montante = 0, salario;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionarios) {
			
			anosDeServico = funcionario.contratacao.until(data, ChronoUnit.YEARS);
			
			salario = funcionario.getSalario() + funcionario.getBonus()*anosDeServico;
			montante += salario;
		}
		
		return montante;
		
	}
	
	//Metodo responsavel por o valor total pago em benefícios
	public float valorTotalB(ArrayList<Funcionario> funcionariosComBenefico, YearMonth data) {
		float montante = 0, beneficio, valorEmVendas, salario;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionariosComBenefico) {
			
			anosDeServico = funcionario.contratacao.until(data, ChronoUnit.YEARS);
			
			salario = funcionario.getSalario() + funcionario.getBonus()*anosDeServico;
			beneficio = funcionario.getBeneficio();
			
			if (funcionario instanceof Secretario) {
				montante += beneficio*salario;
			}
			else if (funcionario instanceof Vendedor) {
				valorEmVendas = calcularBeneficioDeVendas(((Vendedor)(funcionario)).getListaDeVendas(),data);
				montante += valorEmVendas*beneficio;
			}	
		}

		return montante;
	}
	
	//Metodo responsavel por achar o funcionário mais bem pago
	public String valorMaisAltoSB(ArrayList<Funcionario> funcionarios, YearMonth data) {
		String funcionarioMaisPago = "";
		float valorGanho = 0, beneficio, valorEmVendas, salario, valorMaisAlto = 0;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionarios) {
				
			anosDeServico = funcionario.contratacao.until(data, ChronoUnit.YEARS);
				
			salario = funcionario.getSalario() + funcionario.getBonus()*anosDeServico;
			valorGanho += salario;
			beneficio = funcionario.getBeneficio();
				
			if (funcionario instanceof Secretario) {
				valorGanho += beneficio*salario;
			}
			else if (funcionario instanceof Vendedor) {
				valorEmVendas = calcularBeneficioDeVendas(((Vendedor)(funcionario)).getListaDeVendas(),data);
				valorGanho += valorEmVendas*beneficio;
			}	
			
			if (valorGanho >= valorMaisAlto) {
				valorMaisAlto = valorGanho;
				funcionarioMaisPago = funcionario.getNome();
			}
			
		}
				
			return funcionarioMaisPago;
	}
	
	//Metodo responsavel por achar o funcionário que recebeu mais benefício
	public String valorMaisAltoB(ArrayList<Funcionario> funcionariosComBenefico, YearMonth data) {
		String funcionarioMaisPago = "";
		float valorGanho = 0, beneficio, valorEmVendas, salario, valorMaisAlto = 0;
		long anosDeServico;
		
		for(Funcionario funcionario : funcionariosComBenefico) {
			
			anosDeServico = funcionario.contratacao.until(data, ChronoUnit.YEARS);
			
			salario = funcionario.getSalario() + funcionario.getBonus()*anosDeServico;
			beneficio = funcionario.getBeneficio();
			
			if (funcionario instanceof Secretario) {
				valorGanho += beneficio*salario;
			}
			else if (funcionario instanceof Vendedor) {
				valorEmVendas = calcularBeneficioDeVendas(((Vendedor)(funcionario)).getListaDeVendas(),data);
				valorGanho += valorEmVendas*beneficio;
			}	
			
			if (valorGanho >= valorMaisAlto) {
				valorMaisAlto = valorGanho;
				funcionarioMaisPago = funcionario.getNome();
			}
			
		}
		
		return funcionarioMaisPago;
	}
	
	//Metodo responsavel por achar o melhor vendedor
	public String melhorVendedor(ArrayList<Funcionario> funcionarios, YearMonth data) {
		String melhorVendedor = "";
		float valorEmVendas, valorMaisAlto = 0;
		
		for(Funcionario funcionario : funcionarios) {
			
			valorEmVendas = calcularBeneficioDeVendas(((Vendedor)(funcionario)).getListaDeVendas(),data);
			
			if (valorEmVendas >= valorMaisAlto) {
				valorMaisAlto = valorEmVendas;
				melhorVendedor = funcionario.getNome();
			}
			
		}
		
		return melhorVendedor;
	}
		
	
	
	
	
}
