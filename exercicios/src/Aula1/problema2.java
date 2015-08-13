// Rafael Ferreira https://github.com/gipmon/p3

package Aula1;

import java.util.Scanner;

public class problema2{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		Agenda agd = new Agenda();
		
		do{
			menu();
			option = sc.nextInt();
			switch(option){
				case 1:
					System.out.print("Nome: ");
					sc.nextLine();
					String nome = sc.nextLine();
					
					System.out.print("Número do cartão do cidadão: ");
					int cc = sc.nextInt();
					
					System.out.println("--Data de nascimento--");
					System.out.print("Dia: ");
					int dia = sc.nextInt();
					
					System.out.print("Mês: ");
					int mes = sc.nextInt();

					System.out.print("Ano: ");
					int ano = sc.nextInt();
					
					Data ddn = new Data(dia, mes, ano);
					Pessoa nova = new Pessoa(nome, cc, ddn);
					
					agd.add(nome, nova);
					break;
				case 2:
					System.out.print("Indique o nome da pessoa a apagar: ");
					sc.nextLine();
					agd.remove(sc.nextLine());
					break;
				case 3:
					System.out.println(agd.list(0));
					break;
				case 4:
					System.out.println(agd.list(1));
					break;
				case 5:
					System.out.println(agd.list(2));
					break;
			}
		}while(option!=9);
	}
	private static void menu(){
		System.out.println("1. Adicionar pessoa");
		System.out.println("2. Apagar pessoa");
		System.out.println("3. Apresentar lista");
		System.out.println("4. Apresentar lista ordenada por nome");
		System.out.println("5. Apresentar lista ordenada por CC");
		System.out.println("9. Sair");
		System.out.print("Opção: ");
	}
}
