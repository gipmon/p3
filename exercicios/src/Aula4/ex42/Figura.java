package Aula4.ex42;
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
	
	@Override public String toString(){
		return "Centro: "+centro;
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
}