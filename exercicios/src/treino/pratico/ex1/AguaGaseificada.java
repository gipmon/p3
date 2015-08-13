// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

public class AguaGaseificada extends Agua implements Gaseificada{

	public AguaGaseificada(String nome, int quantidade, double preco, Tipo tipo) {
		super(nome, quantidade, preco, tipo);
	}
	
	@Override public String toString(){
		return super.toString()+" GASEIFICADA.";
	}
	
}
