package teste_orientacao_a_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Main {
	
	public static void main(String[] args) {
//		YearMonth contratacao = YearMonth.of(2022, 3);
//		Gerente teste = new Gerente("Matheus", contratacao);
		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
//		Funcionario funcionario = new Gerente("Nome", contratacao);
		
//		File file = new File("dados.csv");
//		try {
//			Scanner scanner = new Scanner(file);
//			scanner.useDelimiter(",");
//			while (scanner.hasNextLine()) {
//				String s[] = scanner.nextLine().split(",");
//				String contratacao[] = s[2].split("/");
//				if (s[1] == "Secretário") {
//					funcionarios.add(new Secretario(s[0],YearMonth.of(, 0)));
//				}
//				else if(s[1] == "Vendedor") {
//					
//				}
//				else {
//					
//				}
//				System.out.println(scanner.nextLine());
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		
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
		
		
		Gerenciadora gerenciadora = new Gerenciadora();
		gerenciadora.valorTotalSB(funcionarios);
		
		
		if (funcionarios.get(4) instanceof Gerente) {
			System.out.println("Gerente");
		};
		
		

		
		System.out.println("Hello World!");
		
		
	}
	

}
