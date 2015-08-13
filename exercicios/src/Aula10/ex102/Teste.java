// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex102;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Teste {
	public static void main(String[] args) { 
		BinarySearchTree<Figura> bst = new BinarySearchTree<Figura>(); 
		
		bst.insert(new Circulo (1,3, 1));
		bst.insert(new Circulo (1,5, 1));
		bst.insert(new Quadrado(3,4, 2));
		bst.insert(new Rectangulo(1,2, 2,5));
		
		/*
		LinkedList<? extends Figura> d;
		LinkedList<Rectangulo> c = new LinkedList<Rectangulo>();
		Rectangulo r = new Rectangulo(3,4, 2, 3);
		c.add(r);
		d = c;
		*/
		
		Iterator<Figura> it = bst.iterator();
		it.remove();
		printSet(it);
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(bst.iterator()));
	}
	
	private static <T> double sumArea(Iterator<T> it) {
		double sum = 0;
		try{
			while(it.hasNext()){
				sum += ((Figura)(it.next())).area();
			}
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		return sum;
	}

	private static <T> void printSet(Iterator<T> iterator) {
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}