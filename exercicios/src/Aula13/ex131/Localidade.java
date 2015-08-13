// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex131;

public class Localidade extends Regiao{
	
	private static final long serialVersionUID = 1L;
	private TipoLocalidade tipo;
	
	public Localidade(String nome, int populacao, TipoLocalidade tipo){
		super(nome, populacao);
		this.setTipo(tipo);
	}
	
	
	public TipoLocalidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoLocalidade tipo) {
		this.tipo = tipo;
	}
	
	@Override public boolean equals(Object b){
		return (((Localidade)b).tipo).equals(tipo);
	}
	
	@Override public String toString(){
		return tipo+": "+super.toString()+"\n";
	}
	
}
