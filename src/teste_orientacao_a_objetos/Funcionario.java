package teste_orientacao_a_objetos;
import java.time.YearMonth;

//Superclasse abstrata funcionario
public abstract class Funcionario {

	private String nome;
	YearMonth contratacao;
	
	public Funcionario (String nome,  YearMonth contratacao) {
		this.nome = nome;
		this.contratacao = contratacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setContratacao(YearMonth contratacao) {
		this.contratacao = contratacao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public YearMonth getContratacao() {
		return this.contratacao;
	}
	
	// Retorna o salario do funcionario em um determinado mes e ano
	abstract public float getSalario(YearMonth data);
	// Retorna o beneficio do funcionario em um determinado mes e ano
	abstract public float getBeneficio(YearMonth data);
}
