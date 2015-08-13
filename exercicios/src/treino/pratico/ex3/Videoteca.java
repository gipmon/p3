// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Videoteca implements Iterable<Artigo>{

	private String nome;
	private VectorGenerico<Artigo> catalogo = new VectorGenerico<>();
	
	public Videoteca(String nome){
		this.nome = nome;
	}
	
	public void add(Artigo[] artigos) {
		for(Artigo a : artigos){
			catalogo.add(a);
		}
	}
	
	public String getNome(){
		return nome;
	}

	public Iterator<Artigo> iterator(int i, int j) {
		return catalogo.iterator(i, j);
	}
	
	public Iterator<Artigo> iterator() {
		return catalogo.iterator();
	}
	
	public List<Artigo> getArtigosSemArtista() {
		List<Artigo> lista = new LinkedList<Artigo>();
		for(Artigo a : catalogo){
			if(a.getArtistas().isEmpty()){
				lista.add(a);
			}
		}
		return lista;
	}
	
}
