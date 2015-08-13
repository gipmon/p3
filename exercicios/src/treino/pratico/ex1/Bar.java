// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

import java.util.Iterator;

public class Bar {
	private String nome;
	ListaGeneric<Bebida> bebidas;
	
	public Bar(String nome){
		this.setNome(nome);
		this.bebidas = new ListaGeneric<Bebida>();
	}
	
	public boolean add(Bebida bebida){
		if(this.bebidas.exists(bebida)){
			return false;
		}else{
			this.bebidas.add(bebida);
			return true;
		}
	}
	
	public Iterator<Bebida> iterator(){
		return bebidas.iterator();
	}

	public String getNome() {
		return nome;
	}
	
	/*
	 * O bar pode mudar de nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
