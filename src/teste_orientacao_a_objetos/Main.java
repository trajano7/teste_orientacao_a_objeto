package teste_orientacao_a_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		ArrayList<Funcionario> funcionariosAuxiliar;
		YearMonth data = YearMonth.now();
		
		//Inicializa todos os objetos necessarios
		ArrayList<Venda> vendas1 = new ArrayList<>();
		vendas1.add(new Venda(YearMonth.of(2021, 12),5200));
		vendas1.add(new Venda(YearMonth.of(2022, 1),4000));
		vendas1.add(new Venda(YearMonth.of(2022, 2),4200));
		vendas1.add(new Venda(YearMonth.of(2022, 3),5850));
		vendas1.add(new Venda(YearMonth.of(2022, 4),7000));
		
		ArrayList<Venda> vendas2 = new ArrayList<>();
		vendas2.add(new Venda(YearMonth.of(2021, 12),3400));
		vendas2.add(new Venda(YearMonth.of(2022, 1),7700));
		vendas2.add(new Venda(YearMonth.of(2022, 2),5000));
		vendas2.add(new Venda(YearMonth.of(2022, 3),5900));
		vendas2.add(new Venda(YearMonth.of(2022, 4),6500));
		
		funcionarios.add(new Secretario("Jorge Carvalho",YearMonth.of(2018, 1)));
		funcionarios.add(new Secretario("Maria Souza",YearMonth.of(2015, 12)));
		funcionarios.add(new Vendedor("Ana Silva",YearMonth.of(2021, 12),vendas1));
		funcionarios.add(new Vendedor("João Mendes",YearMonth.of(2021, 12),vendas2));
		funcionarios.add(new Gerente("Juliana Alves",YearMonth.of(2017, 07)));
		funcionarios.add(new Gerente("Bento Albino",YearMonth.of(2014, 03)));
		
		Calculadora calculadora = new Calculadora();
		
		//Input e chamada do metodo escolhido
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha uma opção: \n"
							+ "0. Valor total pago em salários e benefícios\n"
							+ "1. Valor total pago em salários\n"
							+ "2. Valor total pago em benefícios\n"
							+ "3. Funcionário mais bem pago\n"
							+ "4. Funcionário que recebeu mais benefício\n"
							+ "5. Melhor vendedor\n");
		int i = scan.nextInt();
		System.out.println("Digite o mês e ano que deseja no formato 'ano-mês' (ex: 2022-05):");
		String s = scan.next();
		
		try {
			data = YearMonth.parse(s);	
		}
		catch(DateTimeParseException a) {
			System.out.println("Data em formato errado!");
			return;
		}
		
		switch (i) {
			case 0:
				System.out.println("Valor total pago (salarios/beneficios): ");
				System.out.println(calculadora.valorTotalSB(funcionarios, data));
				break;
			case 1:
				System.out.println("Valor total pago (salarios): ");
				System.out.println(calculadora.valorTotalS(funcionarios, data));
				break;
			case 2:
				System.out.println("Valor total pago (beneficios): ");
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> (funcionario instanceof Gerente));
				System.out.println(calculadora.valorTotalB(funcionariosAuxiliar, data));
				break;
			case 3:
				System.out.println("Funcionario mais bem pago: ");
				System.out.println(calculadora.valorMaisAltoSB(funcionarios, data));
				break;
			case 4: 
				System.out.println("Funcionario que recebeu mais beneficios: ");
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> (funcionario instanceof Gerente));
				System.out.println(calculadora.valorMaisAltoB(funcionariosAuxiliar, data));
				break;
			case 5:
				System.out.println("Vendedor que vendeu mais: ");
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> !(funcionario instanceof Vendedor));
				System.out.println(calculadora.melhorVendedor(funcionariosAuxiliar, data));
				break;
			default:
				System.out.println("Essa opção não é válida!");
		}
		
		
	}
	

}
