// Rafael Ferreira https://github.com/gipmon/p3

package Aula7.ex71;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.Serializable;

public abstract class Figura implements Comparable, Serializable{
	
	private static final long serialVersionUID = 1L;
	private Ponto centro;
	
	public Figura(Ponto centro){
		this.centro = centro;
	}
	
	public Ponto getCentro(){
		return centro;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	@Override public int compareTo(Object b){
		if(this.area()<((Figura)b).area()){
			return -1;
		}else if(this.area()>((Figura)b).area()){
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return centro.equals(((Figura)b).centro);
	}

	@Override public String toString(){
		return "Centro: "+centro;
	}
	
}

