/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex91;

public class Xadrezista extends JogaDecorador{

	public Xadrezista(JogadorInterface j) {
		super(j);
	}

	@Override public String joga() {
		return super.joga() + " Xadrezista";
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b);
	}
}