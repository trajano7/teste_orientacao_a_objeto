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
	
	abstract public void setSalario(float salario);
	abstract public void setBonus(float bonus);
	abstract public void setBeneficio(float beneficio);

	abstract public float getSalario();
	abstract public float getBonus();
	abstract public float getBeneficio();

	
	
	
}
