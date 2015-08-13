package Aula5.ex52;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Sapatilha extends Calcado implements Desportivo{
	public enum Tipo{Atletismo, Futebol, Ginastica, Montanha};

	private Tipo t;
	
	public Sapatilha(String nome, String fabricante, double preco, String t){
		super(nome, fabricante, preco);
		this.t = Tipo.valueOf(t);
	}
	
	public String getFinalidade(){
		return t.toString();
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && t.equals(((Sapatilha)b).t);
	}
	
	@Override public String toString(){
		return super.toString()+"\nFinalidade: "+getFinalidade();
	}
}
