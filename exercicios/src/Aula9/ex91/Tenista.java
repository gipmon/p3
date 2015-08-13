// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex91;

public class Tenista extends JogaDecorador{

	public Tenista(JogadorInterface j) {
		super(j);
	}

	@Override public String joga() {
		return super.joga() + " tenista";
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b);
	}
}
