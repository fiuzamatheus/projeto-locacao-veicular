package Servicos;

import java.time.Duration;

import Entidades.Fatura;
import Entidades.Locacao;



public class AluguelService {
	
	private Double precoHora;
	private Double precoDia;
	
	private ImpostoService imposto;

	public AluguelService(Double precoHora, Double precoDia, ImpostoService imposto) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.imposto = imposto;
	}
	
	
	public void emissaoFatura(Locacao locacao) {
		
		double minutos = Duration.between(locacao.getEntrada(), locacao.getSaida()).toMinutes();
		double horas = minutos / 60;
		
		double pagamentoBasico;
		if(horas < 12) {
			pagamentoBasico = precoHora * Math.ceil(horas);
		}
		else {
			pagamentoBasico = precoDia * Math.ceil(horas / 24);
			
		}
		
		double taxa = imposto.taxa(pagamentoBasico);
		
		locacao.setFatura(new Fatura(pagamentoBasico, taxa));
		
	}
	
	

}
