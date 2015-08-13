// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex131;

public class Estado extends Regiao{
	
	private static final long serialVersionUID = 1L;
	private Localidade capital;
	
	public Estado(String nome, int populacao, Localidade capital){
		super(nome, populacao);
		this.setCapital(capital);
	}
	
	public Localidade getCapital() {
		return capital;
	}

	public void setCapital(Localidade capital) {
		this.capital = capital;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && (((Estado)b).capital).equals(capital);
	}
	
	@Override public String toString(){
		return "ESTADO: "+super.toString()+capital+"\n";
	}
}
