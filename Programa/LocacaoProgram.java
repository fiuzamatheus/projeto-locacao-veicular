package Programa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Locacao;
import Entidades.Veiculo;
import Servicos.AluguelService;
import Servicos.ImpostoBrasil;


public class LocacaoProgram {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("INFORME OS DADOS DE LOCAÇÃO: ");
		System.out.print("MODELO DO CARRO: ");
		String carro = sc.nextLine();
		System.out.print("DATA DE RETIRADA (DD/MM/YYYY HH:MM): ");
		LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(),fmt);
		System.out.print("DATA DE ENTREGA (DD/MM/YYYY HH:MM): ");
		LocalDateTime entrega = LocalDateTime.parse(sc.nextLine(),fmt);
		
		Locacao locacao = new Locacao(retirada, entrega, new Veiculo(carro));
		
		System.out.print("PREÇO POR HORA: ");
		double precoHora = sc.nextDouble();
		System.out.print("PREÇO POR DIA: ");
		double precoDia = sc.nextDouble();
		
		AluguelService aluguelService = new AluguelService(precoHora, precoDia, new ImpostoBrasil());
		
		aluguelService.emissaoFatura(locacao);
		
		System.out.println("FATURA: ");
		System.out.println("VALOR BÁSICO: R$" + String.format("%.2f", locacao.getFatura().getValorBase()));
		System.out.println("IMPOSTO: R$" + String.format("%.2f",locacao.getFatura().getTaxa()));
		System.out.println("VALOR TOTAL: R$" + String.format("%.2f",locacao.getFatura().pagamentoTotal())	);
		
		
		sc.close();
	}
	
}
