package Aula13.ex131;

public class Provincia extends Regiao{
	
	private static final long serialVersionUID = 1L;
	private String governador;
		
	public Provincia(String nome, int populacao, String governador) {
		super(nome, populacao);
		this.setGovernador(governador);
	}

	public String getGovernador() {
		return governador;
	}

	public void setGovernador(String governador) {
		this.governador = governador;
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && (((Provincia)b).governador).equals(governador);
	}
	
	@Override public String toString(){
		return "PROVINCIA: "+super.toString()+governador+"\n";
	}
	
}
