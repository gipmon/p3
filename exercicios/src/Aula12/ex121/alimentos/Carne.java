package Aula12.ex121.alimentos;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

public class Carne extends Alimento{
	
	private static final long serialVersionUID = 1L;

	public enum VariedadeCarne{Vaca, Porco, Peru, Frango, Outra};
	private VariedadeCarne variedade;
	
	public Carne(VariedadeCarne variedade, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && variedade.equals(((Carne)b).variedade);
	}
	
	@Override public String toString(){
		return "Carne "+variedade+", "+super.toString();
	}
		
}
