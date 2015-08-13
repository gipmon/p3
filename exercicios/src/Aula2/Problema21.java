package Aula2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author António Ferreira
 * nmec 67405
 */
public class Problema21 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("--Bem vindo!--");
			System.out.print("Limite máximo da quota de empréstimo: ");
			VideoClube vc = new VideoClube(sc.nextInt());
			
			int opcao = 0;
			/*
			vc.addUser("António", new Data(20, 10, 1994), 12345, 67405, 1347);
			vc.addUser("Rafael", new Data(28, 1, 1994), 12345, 67405, "Engenharia de Computadores e Telemática");
			
			vc.addVideo("Facebook Request", "Action", "ALL");
			vc.addVideo("Request", "Action", "M18");
			vc.addVideo("Eu", "Action", "M18");
			
			vc.addEmprestimo(1, 1);
			vc.outEmprestimo(1, 7);
			vc.addEmprestimo(1, 1);
			vc.outEmprestimo(1, 10);
			
			vc.addEmprestimo(2, 1);
			vc.outEmprestimo(2, 9);
			
			vc.addEmprestimo(3, 1);
			vc.outEmprestimo(3, 10);
			*/
			do{
				sc.nextLine(); 
				System.out.println("<<Clique para o menu>>");
				sc.nextLine();
				try{
					menu();
					opcao = sc.nextInt();
					System.out.println();
					
					switch(opcao){
						case 1:
							sc.nextLine();
							System.out.println("--Adicionar utilizador--");
							System.out.print("Nome: ");
							String nome = sc.next();
							
							System.out.println("Data de nascimento:");
							System.out.print("Dia: ");
							int dia = sc.nextInt();
							System.out.print("Mês: ");
							int mes = sc.nextInt();
							System.out.print("Ano: ");
							int ano = sc.nextInt();
							
							Data ddn = new Data(dia, mes, ano);
							
							System.out.print("Número de CC: ");
							int cc = sc.nextInt();
							
							System.out.print("Funcionário (0) ou Estudante (1) ?");
							int opt = sc.nextInt();
							if(opt!=0 && opt!= 1){
								throw new IllegalArgumentException("Digite 0 para Funcionário e 1 para Estudante!");
							}
							
							if(opt==0){
								System.out.print("Número de funcionário: ");
								int nfunc = sc.nextInt();
								System.out.print("Número fiscal: ");
								int nfisc = sc.nextInt();
								
								System.out.println("#Número de sócio: "+vc.addUser(nome, ddn, cc, nfunc, nfisc));
							}else{
								System.out.print("Número mecanográfico: ");
								int nmec = sc.nextInt();
								System.out.print("Curso: ");
								String curso = sc.next();
								
								System.out.println("#Número de sócio: "+vc.addUser(nome, ddn, cc, nmec, curso));
							}
							break;
						case 2:
							System.out.println("--Remover utilizador--");
							System.out.print("Número de sócio: ");
							int id = sc.nextInt();
							System.out.println(vc.removeUser(id));
							break;
						case 3:
							System.out.println("--Ver informações de um utilizador--");
							System.out.print("Número de sócio: ");
							id = sc.nextInt();
							System.out.println(vc.userDetails(id));
							break;
						case 4:
							System.out.println("--Filmes de um utilizador--");
							System.out.print("Número de sócio do utilizador que pretende ver: ");
							int id_user = sc.nextInt();
							System.out.println(vc.listVideosUser(id_user));
							break;
						case 5:
							System.out.println("--Ver histórico de filmes de um utilizador--");
							System.out.print("Número de sócio do utilizador que pretende ver: ");
							id_user = sc.nextInt();
							System.out.println(vc.listLastUserVideos(id_user));
							break;
						case 6:
							System.out.println("--Introduzir um filme--");
							
							System.out.print("Título: ");
							String titulo = sc.next();
							
							System.out.print("Categoria: ");
							String categoria = sc.next();
							
							System.out.print("Idade (ALL, M6, M12, M16, M18): ");
							String idade = sc.next();
							
							System.out.println("ID do filme: "+vc.addVideo(titulo, categoria, idade));
							break;
						case 7:
							System.out.println("--Remover um filme--");
							System.out.print("ID do filme: ");
							int id_video = sc.nextInt();
							System.out.println(vc.removeVideo(id_video));
							break;
						case 8:
							System.out.println("--Ver informações do filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.println(vc.videoDetails(id_video));
							break;
						case 9:
							System.out.println("--Verificiar disponibilidade do filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							if(vc.filmeDisponivel(id_video)){
								System.out.println("O filme está disponível!");
								System.out.println(vc.videoRating(id_video));
							}else{
								System.out.println("O filme não está disponível!");
							}
							break;
						case 10:
							System.out.println("--Ver utilizadores que requisitaram filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.println(vc.listHistoricoVideo(id_video));
							break;
						case 11:
							System.out.println("--Efectuar empréstimo (checkout)--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.print("Nº de sócio: ");
							id_user = sc.nextInt();
							System.out.println(vc.addEmprestimo(id_video, id_user));
							break;
						case 12:
							System.out.println("--Devolução (checkin)--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.print("Rate do filme (0-10): ");
							double rate = sc.nextDouble();
							System.out.println(vc.outEmprestimo(id_video, rate));
							break;
						case 13:
							System.out.println("--Ver rating de um filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.println(vc.videoRating(id_video));
							break;
						case 14:
							System.out.println("--Listar por rating (desc)--");
							System.out.println(vc.listByRating());
							break;
					}
				}catch(InputMismatchException e){
					System.out.println("Por favor, insira corretamente o que é pedido!");
				}catch(NumberFormatException e){
					System.out.println("Por favor, insira apenas números!");
				}catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}while(opcao!=15);
			
		}catch(InputMismatchException e){
			System.out.println("Por favor, insira apenas números!");
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}	
	}
	
	private static void menu(){
		System.out.println("-- Gestão de Utilizadores --");
		System.out.println("1. Adicionar utilizadores");
		System.out.println("2. Remover utilizadores");
		System.out.println("3. Ver informações de um utilizador");
		System.out.println("4. Pesquisar e listar filmes de um utilizador");
		System.out.println("5. Ver histórico de filmes de um utilizador");
		System.out.println("-- Gestão  de filmes --");
		System.out.println("6. Adicionar filme");
		System.out.println("7. Remover filme");
		System.out.println("8. Ver informações do filme");
		System.out.println("9. Verificar disponibiliade do filme");
		System.out.println("10. Ver utilizadores que requisitaram filme");
		System.out.println("-- Empréstimos --");
		System.out.println("11. Efectuar empréstimo (checkout)");
		System.out.println("12. Devolução (checkin)");
		System.out.println("-- Rating --");
		System.out.println("13.Ver rating de um filme");
		System.out.println("14.Listar por rating (DESC)");
		System.out.println("---  15 Sair  ---");
		System.out.print("Opção: ");
	}

}
