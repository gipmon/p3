// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex51;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public final double getX(){
		return x;
	}
	
	public final double getY(){
		return y;
	}
	
	public double distancia(Ponto b){
		return Math.sqrt(Math.pow((this.x-b.x), 2)+Math.pow((this.y-b.y), 2));
	}
	
	public boolean equalsX(Ponto b){
		return this.x==b.x;
	}
	
	public boolean equalsY(Ponto b){
		return this.y==b.y;
	}
	
	@Override public boolean equals(Object b){
		if(b==null)
			return false;
		if(b.getClass() != getClass())
			return false;
		return x==((Ponto)b).x && y==((Ponto)b).y;
	}
	
	@Override public String toString(){
		return "x:"+x+", y:"+y; 
	}
}