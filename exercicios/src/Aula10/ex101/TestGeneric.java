// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex101;
/**
 * @author Ant???nio Rafael Ferreira
 * nmec 67405
 */
public abstract class TestGeneric {
	public static void main(String[] args) {
		VectorGeneric<Pessoa> vp = new VectorGeneric<>(); 
		
		for (int i=0; i<10; i++)
			vp.addElem(new Pessoa("Bebe?? no Vector "+i, 1000+i, Data.today()));
			
		Iterator<Pessoa> vec = vp.iterator(); 
		printSet(vp.iterator());
			
		ListaGeneric<Pessoa> lp = new ListaGeneric<>(); 
		
		while (vec.hasNext())
			lp.addElem(vec.next());
			
		Iterator<Pessoa> lista = lp.iterator(); 
		
		while ( lista.hasNext() )
			System.out.println(lista.next());
		
		ListaGeneric<Figura> figList = new ListaGeneric<>(); 
		
		figList.addElem(new Circulo (1,3, 1));
		figList.addElem(new Quadrado(3,4, 2));
		figList.addElem(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		ListaGeneric<Rectangulo> quadList = new ListaGeneric<>();
		
		quadList.addElem(new Quadrado(3,4, 2)); 
		quadList.addElem(new Rectangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));
	}

	private static <T> double sumArea(ListaGeneric<T> quadList) {
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
