package Aula10.ex102;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
public class Rectangulo extends Figura{
	
	private double altura;
	private double comprimento;
	
	public Rectangulo(double cx, double cy, double comprimento, double altura){
		super(new Ponto(cx, cy));
		
		if(altura<=0){
			throw new IllegalArgumentException("Altura inv?lida!");
		}
		if(comprimento<=0){
			throw new IllegalArgumentException("Comprimento inv?lido!");
		}
		this.altura = altura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(Ponto centro, double comprimento, double altura){
		super(centro);
		this.altura = altura;
		this.comprimento = comprimento;
	}
	
	public Rectangulo(double comprimento, double altura){
		this(0, 0, comprimento, altura);
	}
	
	public Rectangulo(Rectangulo b){
		this(b.getCentro(), b.getComprimento(), b.getAltura());
	}
	
	public double area(){
		return comprimento*altura;
	}
	
	public double perimetro(){
		return comprimento*2+altura*2;
	}
	
	public final double getComprimento(){
		return comprimento;
	}
	
	public final double getAltura(){
		return altura;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && altura == ((Rectangulo)b).altura && comprimento == ((Rectangulo)b).comprimento;
	}
	
	@Override public String toString(){
		return "Rect?ngulo de Centro "+getCentro()+", altura "+altura+", comprimento: "+comprimento;
	}
}

