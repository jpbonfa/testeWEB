package br.com.testeWEB.model;

public class Tenis {

	private String modelo;
	private int numeracao;
	private String marca;
	private double valor;
	private char disponivel;

	public Tenis() {
	}

	public Tenis(String modelo, int numeracao, String marca, double valor, char disponivel) {

		this.modelo = modelo;
		this.numeracao = numeracao;
		this.marca = marca;
		this.valor = valor;
		this.disponivel = disponivel;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public char getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(char disponivel) {
		this.disponivel = disponivel;
	}
	
}
