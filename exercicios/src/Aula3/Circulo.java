package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Circulo extends Figura{
	
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
	
	public double getArea(){
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double getPerimetro(){
		return 2*Math.PI*raio;
	}
	
	public double getRaio(){
		return raio;
	}

	public boolean intercept(Circulo b){
		return this.raio+b.getRaio()>=this.getCentro().distancia(b.getCentro());
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Figura)b) && raio==((Circulo)b).getRaio();
	}
	
	@Override public String toString(){
		String out = "--C’rculo--\n\n";
		out += "Ponto do centro: "+getCentro()+"\n";
		out += "Raio: "+raio+"\n";
		out += "çrea: "+String.format("%.2f", getArea())+"\n";
		out += "Per’metro: "+String.format("%.2f", getPerimetro());
		return out;
	}
	
}