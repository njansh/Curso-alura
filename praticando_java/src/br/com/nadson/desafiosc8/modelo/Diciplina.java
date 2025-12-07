package br.com.nadson.desafiosc8.modelo;

import java.util.ArrayList;
import java.util.List;

public class Diciplina {
	private String diciplina;
	private List<Double> notasValidas = new ArrayList<>();
	private List<Double> notasInvalidas = new ArrayList<>();

	public Diciplina(String diciplina) {
		this.diciplina = diciplina;
	}

	public String getDiciplina() {
		return diciplina;
	}

	public List<Double> getNotasValidas() {
		return notasValidas;
	}

	public List<Double> getNotasInvalidas() {
	
		return notasInvalidas;
	}

	public void adicionarNota(double nota) {
		if (nota >= 0 && nota <= 10) {
			notasValidas.add(nota);
		} else {
			System.out.println("Nota inválida: " + nota);
			notasInvalidas.add(nota);
		}
	}
	
	public double calcularMedia() {
		if (notasValidas.isEmpty()) {
			return 0;
		}
		double soma = 0;
		for (double nota : notasValidas) {
			soma += nota;	
		}
		return soma / notasValidas.size();
	}
	
	public void exibirRelatorio() {
		System.out.println("Disciplina: " + diciplina);
		System.out.println("Notas Válidas: " + notasValidas);
		System.out.println("Notas Inválidas: " + notasInvalidas);
		System.out.printf("Média das Notas Válidas: %.2f%n", calcularMedia());
	}
}
