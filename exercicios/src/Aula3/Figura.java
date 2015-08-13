// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Figura{
	
	private Ponto centro;
	
	public Figura(Ponto centro){
		this.centro = centro;
	}
	
	public Ponto getCentro(){
		return centro;
	}
	
	public String toString(){
		return "Centro: "+centro;
	}
	
	public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return centro.equals(((Figura)b).getCentro());
	}
}
