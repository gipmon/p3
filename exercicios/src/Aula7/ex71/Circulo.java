package Aula7.ex71;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.Serializable;

public class Circulo extends Figura implements Serializable{

	private static final long serialVersionUID = 1L;
	private double raio;
	
	public Circulo(Ponto centro, double r){
		super(centro);
		this.raio = r;
	}
	
	public Circulo(double r){
		this(new Ponto(0,0), r);
	}
	
	public Circulo(Circulo b){
		this(b.getCentro(), b.getRaio());
	}
	
	public Circulo(double x, double y, double r){
		this(new Ponto(x, y), r);
	}
	
	public double area(){
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double perimetro(){
		return 2*Math.PI*raio;
	}
	
	public final double getRaio(){
		return raio;
	}

	public boolean intercept(Circulo b){
		return this.raio+b.getRaio()>=this.getCentro().distancia(b.getCentro());
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && raio==((Circulo)b).raio;
	}
	
	@Override public String toString(){
		return "C’rculo de Centro: "+getCentro()+" e de raio: "+raio;
	}
	
}
