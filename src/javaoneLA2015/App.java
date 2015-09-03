package javaoneLA2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

	
	public static void main(String[] args) {
		List<Aluno> turma = new ArrayList<Aluno>();
		turma.add(new Aluno("Joao", 10.0, Sexo.MASCULINO, 20));
		turma.add(new Aluno("Maria", 5.0, Sexo.FEMININO, 21));
		turma.add(new Aluno("Joaquim", 6.0, Sexo.MASCULINO, 20));
		turma.add(new Aluno("Kiko", 7.0, Sexo.MASCULINO, 22));
		
		boolean temAprovado = turma.stream().anyMatch(Aluno::isAprovado);
		boolean temReprovado = turma.stream().anyMatch(Aluno::isReprovado);
		boolean sohTemReprovado = turma.stream().allMatch(Aluno::isReprovado);
		boolean sohTemAprovado = turma.stream().allMatch(Aluno::isAprovado);
		String alunosAprovados = turma.stream().filter(Aluno::isAprovado).map(Aluno::getNome).collect(Collectors.joining());
		String alunosReprovados = turma.stream().filter(Aluno::isReprovado).map(Aluno::getNome).collect(Collectors.joining());
		String alunosAprovadosPorVirgula = turma.stream().map(Aluno::getNome).collect(Collectors.joining(", "));
		String alunosReprovadosPorVirgula = turma.stream().map(Aluno::getNome).collect(Collectors.joining(", "));
		double maiorNota = turma.stream().mapToDouble(Aluno::getNota).max().getAsDouble();
		double menorNota = turma.stream().mapToDouble(Aluno::getNota).min().getAsDouble();
		long qntNotas = turma.stream().mapToDouble(Aluno::getNota).count();
		double totalNotas = turma.stream().mapToDouble(Aluno::getNota).sum();
		double mediaNotas = turma.stream().mapToDouble(Aluno::getNota).average().getAsDouble();
		String alunos = turma.stream().map(Aluno::getNome).collect(Collectors.joining());
		Map<Sexo, List<Aluno>> alunosPorSexo = turma.stream().collect(Collectors.groupingBy(Aluno::getSexo));
		Map<Boolean, List<Aluno>> alunoPorAprovacao = turma.stream().collect(Collectors.groupingBy(Aluno::isAprovado));
		List<Aluno> ordernarPorNotaENome = turma.stream().sorted(Comparator.comparing(Aluno::getNome).thenComparing(Comparator.comparing(Aluno::getNome))).collect(Collectors.toList());
		Collections.sort(turma, (a,b) -> a.getNome().compareTo(b.getNome()));
		
		System.out.println(ordernarPorNotaENome);
		System.out.println(alunoPorAprovacao);
		System.out.println(alunosPorSexo);
		System.out.println("Alunos: "+alunos);
		System.out.println("Média de notas " +mediaNotas);
		System.out.println("Total notas "+ totalNotas);
		System.out.println("Quantidade de notas: " +qntNotas);
		System.out.println("Maior nota: "+maiorNota);
		System.out.println("Menor nota: "+menorNota);
		System.out.println("Tem aprovado: " + temAprovado);
		System.out.println("Tem reprovado: " + temReprovado);
		System.out.println("Só tem aprovado: " + sohTemAprovado);
		System.out.println("Só tem reprovado: " + sohTemReprovado);
		System.out.println("Alunos aprovados: "+ alunosAprovados);
		System.out.println("Alunos aprovados: "+ alunosReprovados);
		System.out.println("Alunos aprovados por virgula: " + alunosAprovadosPorVirgula);
		System.out.println("Alunos reprovados por virgula: " + alunosReprovadosPorVirgula);
	}
	
}
