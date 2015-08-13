// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

public class Vinho extends Bebida implements Alcoolica{
	
	private double teor;
	private Regiao regiao;
	enum Regiao{Douro, Alentejo, Dao, Beiras, Bairrada};
	
	public Vinho(String nome, int quantidade, double preco, double teor, Regiao regiao) {
		super(nome, quantidade, preco);
		this.setRegiao(regiao);
		this.teor = teor;
	}

	@Override public double getTeor() {
		return teor;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && (((Vinho)b).teor==teor) 
				&& (((Vinho)b).regiao==regiao);
	}
	
	@Override public String toString(){
		return super.toString()+", VINHO, teor: "+teor+", regiao: "+regiao;
	}
}
