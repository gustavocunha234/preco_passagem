package lista_15;

import java.text.DecimalFormat;
import java.util.Scanner;

public class preco_passagem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nome[] = new String[100];
		int codDestino[] = new int [100], codTipo[] = new int [100], qtPassagens[] = new int [100], i, qtPassagensSul = 0,totalIdaEvolta = 0,totalFaturado = 0, totalPassagens = 0;
		char flag = 'S';
		float precoPassagem = 0, valorInicial[] = new float [100],mediaFaturado = 0;
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		Scanner leia = new Scanner(System.in);
		for (i = 0; i < 100 && flag != 'N'; i++) {

			System.out.println("Digite o seu nome: ");
			nome[i] = leia.nextLine().toUpperCase();

			do {
				System.out.println(
						"Digite o destino: (1- Região Norte| 2- Região Nordeste| 3- Região Centro-Oeste| 4- Região Sul) ");
				codDestino[i] = leia.nextInt();
				if (codDestino[i] <= 0 || codDestino[i] > 4) {
					System.err.println("O Destino é invalido!!");
				}
			} while (codDestino[i] <= 0 || codDestino[i] > 4);

			do {
				System.out.println("Digite o tipo de viagem: (1- Ida| 2- Ida e Volta)");
				codTipo[i] = leia.nextInt();
				if (codTipo[i] <= 0 || codTipo[i] > 2) {
					System.err.println("O tipo de viagem é invalido!!");
				}
			} while (codTipo[i] <= 0 || codTipo[i] > 2);

			do {
				System.out.println("Digite a quantidade de passagens: ");
				qtPassagens[i] = leia.nextInt();
				if (qtPassagens[i] < 0) {
					System.err.println("A quantidade de passagens NÃO pode ser negativa!!");
				}
			} while (qtPassagens[i] < 0);

			if (codDestino[i] == 1 && codTipo[i] == 1) {
				precoPassagem = 500;
			} else if (codDestino[i] == 1 && codTipo[i] == 2) {
				precoPassagem = 900;
			}
			if (codDestino[i] == 2 && codTipo[i] == 1) {
				precoPassagem = 350;
			} else if (codDestino[i] == 2 && codTipo[i] == 2) {
				precoPassagem = 650;
			}
			if (codDestino[i] == 3 && codTipo[i] == 1) {
				precoPassagem = 350;
			} else if (codDestino[i] == 3 && codTipo[i] == 2) {
				precoPassagem = 600;
			}
			if (codDestino[i] == 4 && codTipo[i] == 1) {
				precoPassagem = 300;
				
			} else if (codDestino[i] == 4 && codTipo[i] == 2) {
				precoPassagem = 550;
			} 
			
			
			
			valorInicial[i] = precoPassagem * qtPassagens[i];
			
			if (qtPassagens[i] > 1) {
				
				valorInicial[i] -=  valorInicial[i] * 0.035f;
			}
			
			if(codDestino[i] == 4 && codTipo[i] == 1 || codDestino[i] == 4 && codTipo[i] == 2) {
				qtPassagensSul+=qtPassagens[i];
			}
			
			if(codTipo[i] == 2) {
				totalIdaEvolta+=qtPassagens[i];
			}
			
			totalFaturado+=qtPassagens[i];
			
			mediaFaturado+=valorInicial[i];
			
			totalPassagens+=qtPassagens[i];
			
			System.out.println("");
			System.out.println("====================== Resultado Intermediário ======================");
			System.out.println("Vendido " + qtPassagens[i] + " passagens para " + nome[i] + " por " + df.format(valorInicial[i]));
			System.out.println("=====================================================================");
			System.out.println("");
			
			do {
				System.out.println("Deseja continuar: S/N");
				flag = leia.next().toUpperCase().charAt(0);

			} while (flag != 'S' && flag != 'N');
			leia.nextLine();
			
		}
		
		System.out.println("====================== Resultado Final ======================");
		
		System.out.println("a)	A quantidade de passagens vendidas para a região Sul: " + qtPassagensSul);
		System.out.println("b)	A média dos valores faturados por todas as passagens: " + df.format(mediaFaturado /i));
		System.out.println("c)	A porcentagem de passagens de ida e volta vendida:   "  + (totalIdaEvolta / (float)  totalPassagens * 100) + " % ");
		System.out.println("d)	Imprimir o relatório final abaixo: ");
		for (int j = 0; j < i; j++) {
			
			System.out.println("");
			System.out.println("============================================");
			System.out.println("Nome do passageiro: " + nome[j]);
			System.out.println("Total de passagens:" + qtPassagens[j]);
			System.out.println("Destino :" + codDestino[j]);
			System.out.println("Passagem: " + codTipo[j]);
			System.out.println("Valor total: " + df.format(valorInicial[j]));
			
			
		}
		
	}
}