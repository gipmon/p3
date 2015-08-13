package Aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(Ponto centro, double r){
		this.centro = centro;
		this.raio = r;
	}
	
	public Circulo(double x, double y, double r){
		this.centro = new Ponto(x, y);
		this.raio = r;
	}
	
	public double area(){
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double perimetro(){
		return 2*Math.PI*raio;
	}
	
	public String toString(){
		String out = "C’rculo\n\n";
		out += "Ponto do centro: "+centro.toString()+"\n";
		out += "Raio: "+raio;
		out += "çrea: "+area()+"\n";
		out += "Per’metro: "+perimetro();
		return out;
	}
	
	public Ponto centro(){
		return this.centro;
	}
	
	public double raio(){
		return raio;
	}
	
	public boolean equals(Circulo b){
		return raio==b.raio();
	}
	
	public boolean intercept(Circulo b){
		return this.raio+b.raio()>=this.centro.distancia(b.centro());
	}
}
