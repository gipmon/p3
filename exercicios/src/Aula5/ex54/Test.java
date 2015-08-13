package Aula5.ex54;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		Agenda agd = new Agenda();
		
		//agd.load("Nokia.txt");
		//agd.load("CSV.txt");
		//agd.load("vCard.txt");
		
		do{
			menu();
			option = sc.nextInt();
			System.out.println();
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
				case 6:
					System.out.print("Nome do ficheiro: ");
					sc.nextLine();
					String name = sc.nextLine();
					agd.load(name);
					break;
				case 7:
					System.out.print("Nome do ficheiro para onde deseja fazer bakcup: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.print("Tecnologia usada (Nokia, vCard, CSV): ");
					String tec = sc.nextLine();
					agd.backup(name, tec);
					break;
				case 8:
					agd = new Agenda();
					break;
			}
			System.out.println();
		}while(option!=9);
	}
	private static void menu(){
		System.out.println("1. Adicionar pessoa");
		System.out.println("2. Apagar pessoa");
		System.out.println("3. Apresentar lista");
		System.out.println("4. Apresentar lista ordenada por nome");
		System.out.println("5. Apresentar lista ordenada por CC");
		System.out.println("---Restore && Backup Options---");
		System.out.println("6. Restaurar de  um ficheiro");
		System.out.println("7. Fazer backup para um ficheiro");
		System.out.println("---DELETE---");
		System.out.println("8. Apagar agenda");
		System.out.println("9. Sair");
		System.out.print("Opção: ");
	}
}
