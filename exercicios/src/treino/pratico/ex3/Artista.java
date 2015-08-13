// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

public class Artista {
	private String nome;
	private int categoria;
	
	public Artista(String nome, int categoria){
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public int getCategoria(){
		return this.categoria;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	@Override public String toString(){
		return "[Artista]: "+nome+" "+categoria+"\n";
	}
}
