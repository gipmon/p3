// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

import java.util.LinkedList;

public class Artigo {
	
	private String titulo;
	private double preco;
	
	LinkedList<Artista> artistas = new LinkedList<>();
	
	private int id;
	private static int n;
	
	static{
		n = 1;
	}
	
	public Artigo(String titulo, double preco){
		this.id = n++;
		this.titulo = titulo;
		this.preco = preco;
	}
	
	public void addArtista(Artista artista){
		artistas.add(artista);
	}
	
	public int getId(){
		return this.id;
	}
	
	public LinkedList<Artista> getArtistas(){
		return artistas;
	}
	
	public double getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }
    
    @Override public String toString(){
    	String out = "[Artigo]\n";
    	out += "\t[Título]: " + this.titulo + "\n";
    	out += "\t[Preço]: " + this.preco + "\n";
    	
    	for(Artista a : artistas){
    		out += "\t" + a;
    	}
    	
    	return out;
    }
}
