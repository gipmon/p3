package Aula12.ex121.geometria;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
public class Quadrado extends Rectangulo{
	public Quadrado(double lado){
		this(new Ponto(0,0), lado);
	}
	
	public Quadrado(Ponto centro, double lado){
		super(centro, lado, lado);
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
