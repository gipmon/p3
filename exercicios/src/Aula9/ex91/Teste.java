// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex91;

public class Teste{
	public static void main(String args[]) {
		JogadorInterface j1 = new Jogador("Rui");
		Futebolista f1 = new Futebolista(new Jogador("Luis"));
		Basquetebolista b1 = new Basquetebolista(new Jogador("Ana"));
		Basquetebolista b2 = new Basquetebolista(j1); 
		Basquetebolista b3 = new Basquetebolista(f1);
		Tenista t1 = new Tenista(j1);
		Tenista t2 = new Tenista(new Basquetebolista(new Futebolista(new Jogador("Bruna"))));
		Xadrezista x1 = new Xadrezista (new Futebolista(new Jogador("Paredes")));
		JogadorInterface lista[] = {j1, f1, b1, b2, b3, t1, t2, x1}; 
		for (JogadorInterface ji: lista)
			System.out.println(ji.joga()); 
	}
}
