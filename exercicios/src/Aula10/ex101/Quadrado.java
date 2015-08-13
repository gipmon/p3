// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex101;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
public class Quadrado extends Rectangulo{
	
	public Quadrado(Ponto centro, double lado){
		super(centro, lado, lado);
	}
	
	public Quadrado(double lado){
		this(new Ponto(0,0), lado);
	}
	
	public Quadrado(double cx, double cy, double lado){
		this(new Ponto(cx, cy), lado);
	}
	
	public Quadrado(Quadrado b){
		this(b.getCentro(), b.getComprimento());
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b);
	}
	
	@Override public String toString(){
		return "Quadrado de Centro "+getCentro()+" e de lado "+getComprimento();
	}
}
