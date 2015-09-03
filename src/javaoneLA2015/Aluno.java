package javaoneLA2015;

public class Aluno {

	private String nome;
	private Double nota;
	private Sexo sexo;
	private int idade;
	


	public Aluno(String nome, Double nota, Sexo sexo, int idade) {
		this.nome = nome;
		this.nota = nota;
		this.sexo = sexo;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public Double getNota() {
		return nota;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", nota=" + nota + ", aprovado= "+ (isAprovado()?true:false) + "]";
	}
	
	public boolean isAprovado(){
		return nota >= 7;
	}
	
	public boolean isReprovado(){
		return !isAprovado();
	}
	
	

}
