package Aula11.ex111.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Aula12.ex121.pessoa.Data;
import Aula12.ex121.pessoa.Pessoa;

/**
 * @author Ant??nio Rafael Ferreira
 * nmec 67405
 */
public abstract class Main {
	public static void main(String[] args) {
		ArrayList<Pessoa> vp = new ArrayList<>(); 
		
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebe?? no Vector "+i, 1000+i, Data.today()));
			
		Iterator<Pessoa> vec = vp.iterator(); 
		printSet(vp.iterator());
			
		LinkedList<Pessoa> lp = new LinkedList<>(); 
		
		while (vec.hasNext())
			lp.add(vec.next());
			
		Iterator<Pessoa> lista = lp.iterator(); 
		
		while ( lista.hasNext() )
			System.out.println(lista.next());
		
		LinkedList<Figura> figList = new LinkedList<>(); 
		
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		LinkedList<Rectangulo> quadList = new LinkedList<>();
		
		quadList.add(new Quadrado(3,4, 2)); 
		quadList.add(new Rectangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}

	private static <T> double sumArea(LinkedList<T> quadList) {
		Iterator<T> it = quadList.iterator();
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
