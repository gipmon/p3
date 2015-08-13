// Rafael Ferreira https://github.com/gipmon/p3

package Aula1;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Ponto b){
		return Math.sqrt(Math.pow((this.x-b.x), 2)+Math.pow((this.y-b.y), 2));
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public boolean equals(Ponto b){
		return x==b.x && y==b.y;
	}
	
	public boolean equalsX(Ponto b){
		return this.x==b.x;
	}
	
	public boolean equalsY(Ponto b){
		return this.y==b.y;
	}
	
	public String toString(){
		return "("+x+" , "+y+")";
	}
}
