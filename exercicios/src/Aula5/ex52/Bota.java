package Aula5.ex52;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Bota extends Calcado{
	public enum Tipo{Cano, MeioCano};
	private Tipo t;
	
	public Bota(String nome, String fabricante, double preco, String t){
		super(nome, fabricante, preco);
		this.t = Tipo.valueOf(t);
	}
	
	public String getTipo(){
		return t.toString();
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && t.equals(((Bota)b).t);
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo: "+t;
	}
}