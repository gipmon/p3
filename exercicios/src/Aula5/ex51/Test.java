// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex51;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Test {
	public static void main(String[]args){ 
		Figura listaFig[] = new Figura[]{
			new Circulo (2),
			new Circulo (1,3, 1), 
			new Quadrado(5),
			new Quadrado(3,4, 2), 
			new Rectangulo(2,3),
			new Rectangulo(3,4, 5,3), 
			new Rectangulo(1,1, 5,6)
		};
		
		for(Figura f : listaFig) {
			System.out.println(f); 
		}
		
		System.out.println("\nComparação da área do primeiro elemento com todos"); 
		
		for(int i = 0; i < listaFig.length; i++){
			System.out.printf("%2d %12s %8.2f compareTo = %2d\n", i, listaFig[i].getClass().getSimpleName(), listaFig[i].area(), listaFig[i].compareTo(listaFig[0]));
		}

		System.out.println("\nFigura com maior Area: " + UtilCompare.findMax( listaFig ) );
		
		// Ordena (crescente) o array de Figuras por areas 
		UtilCompare.sortArray(listaFig);
		
		System.out.println ("\nLista de Figuras Ordenadas por Area:"); 
		
		for (int i = 0; i < listaFig.length; i++) {
			if (listaFig[i] != null){ 
				System.out.print (listaFig[i]); 
				System.out.println (" -> area: " + String.format("%2.2f", listaFig[i].area())+" e perimetro:"+ String.format("%2.2f", listaFig[i].perimetro()));
			} 
		}
	
	} 
}
