// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex101;
/**
 * @author Ant???nio Rafael Ferreira
 * nmec 67405
 */
public class Teste {
	public static void main(String[] args) { 
		VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>(); 
		
		for(int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebe?? no Vector "+i, 1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator(); 
		
		while(vec.hasNext())
			System.out.println(vec.next());
		
		ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>(); 
		
		for (int i=0; i<10; i++)
			lp.addElem(new Pessoa("Bebe?? na Lista "+i, 2000+i, Data.today()));
		
		Iterator<Pessoa> lista = lp.iterator(); 
		
		while (lista.hasNext())
			System.out.println( lista.next() ); 
	}
}