// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

public class Agua extends Bebida{
	private Tipo tipo;
	enum Tipo{Nascente, Mineral};
	
	public Agua(String nome, int quantidade, double preco, Tipo tipo){
		super(nome, quantidade, preco);
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((Agua)b).tipo);
	}
	
	@Override public String toString(){
		return super.toString()+", ÁGUA, tipo: "+tipo;
	}
}
