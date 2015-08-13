package Aula5.ex52;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class BotaDesporto extends Bota implements Desportivo{
	public enum Tipo{SnowBoard, Basket};

	private Tipo t;
	
	public BotaDesporto(String nome, String fabricante, double preco, String t1, String t2){
		super(nome, fabricante, preco, t1);
		this.t = Tipo.valueOf(t2);
	}
	
	public String getFinalidade(){
		return t.toString();
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && t.equals(((BotaDesporto)b).t);
	}
	
	@Override public String toString(){
		return super.toString()+"\nFinalidade: "+getFinalidade();
	}
}
