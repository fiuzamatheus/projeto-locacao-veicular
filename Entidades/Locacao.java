package Entidades;

import java.time.LocalDateTime;


public class Locacao {
	
	
	private LocalDateTime retirada;
	private LocalDateTime entrega;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public Locacao(LocalDateTime retirada, LocalDateTime entrega, Veiculo veiculo) {
		super();
		this.retirada = retirada;
		this.entrega = entrega;
		this.veiculo = veiculo;
	}
	
	
	public LocalDateTime getEntrada() {
		return retirada;
	}
	public void setEntrada(LocalDateTime entrada) {
		this.retirada = entrada;
	}
	public LocalDateTime getSaida() {
		return entrega;
	}
	public void setSaida(LocalDateTime saida) {
		this.entrega = saida;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	

	

}
