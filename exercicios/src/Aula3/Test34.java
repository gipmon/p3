// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test34{
public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("--Bem vindo!--");
			System.out.print("Limite maximo da quota de emprestimo: ");
			VideoClube vc = new VideoClube(sc.nextInt());
			
			int opcao = 0;
			/* Comandos de teste
			System.out.println(vc.addUser("Antonio", new Data(20, 10, 1994), 12345, 67405, 1347));
			System.out.println(vc.addUser("Rafael", new Data(28, 1, 1994), 12345, 67405, "Engenharia de Computadores e Telem�tica"));
			
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
							System.out.print("M�s: ");
							int mes = sc.nextInt();
							System.out.print("Ano: ");
							int ano = sc.nextInt();
							
							Data ddn = new Data(dia, mes, ano);
							
							System.out.print("N�mero de CC: ");
							int cc = sc.nextInt();
							
							System.out.print("Funcion�rio (0) ou Estudante (1) ?");
							int opt = sc.nextInt();
							if(opt!=0 && opt!= 1){
								throw new IllegalArgumentException("Digite 0 para Funcion�rio e 1 para Estudante!");
							}
							
							if(opt==0){
								System.out.print("N�mero de funcion�rio: ");
								int nfunc = sc.nextInt();
								System.out.print("N�mero fiscal: ");
								int nfisc = sc.nextInt();
								
								System.out.println("#N�mero de s�cio: "+vc.addUser(nome, ddn, cc, nfunc, nfisc));
							}else{
								System.out.print("N�mero mecanogr�fico: ");
								int nmec = sc.nextInt();
								System.out.print("Curso: ");
								String curso = sc.next();
								
								System.out.println("#N�mero de s�cio: "+vc.addUser(nome, ddn, cc, nmec, curso));
							}
							break;
						case 2:
							System.out.println("--Remover utilizador--");
							System.out.print("N�mero de s�cio: ");
							int id = sc.nextInt();
							System.out.println(vc.removeUser(id));
							break;
						case 3:
							System.out.println("--Ver informa��es de um utilizador--");
							System.out.print("N�mero de s�cio: ");
							id = sc.nextInt();
							System.out.println(vc.userDetails(id));
							break;
						case 4:
							System.out.println("--Filmes de um utilizador--");
							System.out.print("N�mero de s�cio do utilizador que pretende ver: ");
							int id_user = sc.nextInt();
							System.out.println(vc.listVideosUser(id_user));
							break;
						case 5:
							System.out.println("--Ver hist�rico de filmes de um utilizador--");
							System.out.print("N�mero de s�cio do utilizador que pretende ver: ");
							id_user = sc.nextInt();
							System.out.println(vc.listLastUserVideos(id_user));
							break;
						case 6:
							System.out.println("--Introduzir um filme--");
							
							System.out.print("T�tulo: ");
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
							System.out.println("--Ver informa��es do filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.println(vc.videoDetails(id_video));
							break;
						case 9:
							System.out.println("--Verificiar disponibilidade do filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							if(vc.filmeDisponivel(id_video)){
								System.out.println("O filme est� dispon�vel!");
								System.out.println(vc.videoRating(id_video));
							}else{
								System.out.println("O filme n�o est� disponível!");
							}
							break;
						case 10:
							System.out.println("--Ver utilizadores que requisitaram filme--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.println(vc.listHistoricoVideo(id_video));
							break;
						case 11:
							System.out.println("--Efectuar empr�stimo (checkout)--");
							System.out.print("ID do filme: ");
							id_video = sc.nextInt();
							System.out.print("N� de s�cio: ");
							id_user = sc.nextInt();
							System.out.println(vc.addEmprestimo(id_video, id_user));
							break;
						case 12:
							System.out.println("--Devolu��o (checkin)--");
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
					System.out.println("Por favor, insira corretamente o que � pedido!");
				}catch(NumberFormatException e){
					System.out.println("Por favor, insira apenas n�meros!");
				}catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
			}while(opcao!=15);
			
		}catch(InputMismatchException e){
			System.out.println("Por favor, insira apenas n�meros!");
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}	
	}
	
	private static void menu(){
		System.out.println("-- Gest�o de Utilizadores --");
		System.out.println("1. Adicionar utilizadores");
		System.out.println("2. Remover utilizadores");
		System.out.println("3. Ver informa��es de um utilizador");
		System.out.println("4. Pesquisar e listar filmes de um utilizador");
		System.out.println("5. Ver hist�rico de filmes de um utilizador");
		System.out.println("-- Gest�o  de filmes --");
		System.out.println("6. Adicionar filme");
		System.out.println("7. Remover filme");
		System.out.println("8. Ver informa��es do filme");
		System.out.println("9. Verificar disponibiliade do filme");
		System.out.println("10. Ver utilizadores que requisitaram filme");
		System.out.println("-- Empr�stimos --");
		System.out.println("11. Efectuar empr�stimo (checkout)");
		System.out.println("12. Devolu��o (checkin)");
		System.out.println("-- Rating --");
		System.out.println("13.Ver rating de um filme");
		System.out.println("14.Listar por rating (DESC)");
		System.out.println("---  15 Sair  ---");
		System.out.print("Op��o: ");
	}
}
