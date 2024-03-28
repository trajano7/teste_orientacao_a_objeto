package teste_orientacao_a_objetos;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		ArrayList<Funcionario> funcionariosAuxiliar;
		YearMonth data = YearMonth.now();
		
		//Casos de teste
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
		funcionarios.add(new Vendedor("Joao Mendes",YearMonth.of(2021, 12),vendas2));
		funcionarios.add(new Gerente("Juliana Alves",YearMonth.of(2017, 07)));
		funcionarios.add(new Gerente("Bento Albino",YearMonth.of(2014, 03)));
		
		Calculadora calculadora = new Calculadora();
		
		//Input e chamada do metodo escolhido
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha uma opcao: \n"
							+ "0. Valor total pago em salaios e beneficios\n"
							+ "1. Valor total pago em salarios\n"
							+ "2. Valor total pago em beneficios\n"
							+ "3. Funcionario mais bem pago\n"
							+ "4. Funcionario que recebeu mais beneficio\n"
							+ "5. Melhor vendedor\n");
		int i = scan.nextInt();
		System.out.println("Digite o mes e ano que deseja no formato 'ano-mes' (ex: 2022-05):");
		String s = scan.next();
		
		scan.close();
		
		try {
			data = YearMonth.parse(s);	
		}
		catch(DateTimeParseException a) {
			System.out.println("Data em formato errado!");
			return;
		}
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");    
        String dataFormatada = data.format(formatter);
		
		switch (i) {
			case 0:
				System.out.println("Valor total pago em salarios e beneficios em " + dataFormatada + ": " + calculadora.getTotalPago(funcionarios, data));
				break;
			case 1:
				System.out.println("Valor total pago em salarios em " + dataFormatada + ": " + calculadora.getTotalSalario(funcionarios, data));
				break;
			case 2:
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> (funcionario instanceof Gerente));
				System.out.println("Valor total pago em beneficios em " + dataFormatada + ": " + calculadora.getTotalBeneficio(funcionariosAuxiliar, data));
				break;
			case 3:
				System.out.println("Funcionario mais bem pago em " + dataFormatada + " (Salario + Beneficio): ");
				System.out.println(calculadora.getMelhorPago(funcionarios, data));
				break;
			case 4: 
				System.out.println("Funcionario que recebeu mais beneficios em " + dataFormatada + ": ");
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> (funcionario instanceof Gerente));
				System.out.println(calculadora.getMelhorBeneficiado(funcionariosAuxiliar, data));
				break;
			case 5:
				System.out.println("Vendedor que mais vendeu em " + dataFormatada + ": ");
				funcionariosAuxiliar = (ArrayList<Funcionario>) funcionarios.clone();
				funcionariosAuxiliar.removeIf(funcionario -> !(funcionario instanceof Vendedor));
				System.out.println(calculadora.getMelhorVendedor(funcionariosAuxiliar, data));
				break;
			default:
				System.out.println("Essa opcaoo nao e valida!");
		}
	}
}
