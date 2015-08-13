// Rafael Ferreira https://github.com/gipmon/p3

package Aula11.ex112.alimentos;


/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

public class Peixe extends Alimento{
	
	private static final long serialVersionUID = 1L;

	public enum TipoPeixe{Congelado, Fresco};
	private TipoPeixe tipo;
	
	public Peixe(TipoPeixe tipo, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso);
		this.tipo = tipo;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((Peixe)b).tipo);
	}
	
	@Override public String toString(){
		return "Peixe "+tipo+", "+super.toString();
	}
	
}
