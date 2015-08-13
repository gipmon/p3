// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

public class Espumante extends Vinho implements Gaseificada{

	public Espumante(String nome, int quantidade, double preco, double teor,
			Regiao regiao) {
		super(nome, quantidade, preco, teor, regiao);
	}

	@Override public String toString(){
		return super.toString()+" ESPUMANTE, VINHO GASEIFICADO.";
	}
}
