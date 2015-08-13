// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args){
	       System.out.println("*************** Construção *******************");        
	       
	       Videoteca loja = new Videoteca ("Videoteca Casimiro"); 
	       
	       Artista art1 = new Artista("Tobias Casimiro", 4); 
	       Artista art2 = new Artista("Ana Bela Casimiro", 3);                        
	       Artista art3 = new Artista("Ricardo Cas Miro", 1);                        
	       
	       Artigo [] artigos = {new MP3("Conan o Homem Rã", 18.0, 34),
	                             new CD ("Ai se te pego", 12.5, true),
	                             new Filme("Conan o Homem Rã", 16.9, Classificacao.TERROR),
	                             new Filme("Aveiro tem mais encanto", 12.5, Classificacao.INFANTIL),
	                             new CD("O Herodes já morreu", 12.3, true) };
	       
	       artigos[0].addArtista(art1); artigos[0].addArtista(art2);
	       artigos[1].addArtista(art2); artigos[2].addArtista(art1);
	       artigos[4].addArtista(art1); artigos[4].addArtista(art3);
	       
	       loja.add(artigos); 
	       for (Artigo a: loja)
	    	   System.out.println(a);
	       System.out.println("*************** Iteradores/Conjuntos *******************");        
	        
	       Iterator<Artigo> it1 = loja.iterator(1,2);  
	       while (it1.hasNext()) 
	    	   System.out.print(it1.next().getId()+" ");
	       System.out.println();
	       
	       /*
	       Iterator<Artigo> it2 = loja.iterator(3,0);  
	       while (it2.hasNext()) 
	    	   System.out.print(it2.next().getId()+" ");
	       System.out.println();     
	       */
	       
	       System.out.println("*************** Sem artistas *******************");        
	       List<Artigo> s = loja.getArtigosSemArtista();
	       System.out.println(s);
	}
}
