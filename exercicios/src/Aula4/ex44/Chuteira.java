package Aula4.ex44;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Chuteira extends Sapatilha{
	public enum tipoPitoes{Aluminio, Borracha, Plastico};

	private tipoPitoes t;
	private byte nPitoes;
	
	public Chuteira(String nome, String fabricante, double preco, String pitoes, byte nPitoes){
		super(nome, fabricante, preco, "Futebol");
		this.nPitoes = nPitoes;
		this.t = tipoPitoes.valueOf(pitoes);
	}
	
	public String getTipoPitoes(){
		return t.toString();
	}
	
	public byte getnPitoes() {
		return nPitoes;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && t.equals(((Chuteira)b).t) && nPitoes == ((Chuteira)b).nPitoes;
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de pit›es: "+t+"\nNœmero de pit›es: "+nPitoes;
	}
}
