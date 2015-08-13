// Rafael Ferreira https://github.com/gipmon/p3

package Aula4.ex42;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Test {
	public static void main(String[] args){ 
		Figura listaFig[] = new Figura[15]; 
		
		Circulo c1 = new Circulo(2);
		Circulo c2 = new Circulo(1, 3, 2); 
		
		Quadrado q1 = new Quadrado(2);
		Quadrado q2 = new Quadrado(3, 4, 2); 
		
		Rectangulo r1 = new Rectangulo(2, 3); 
		Rectangulo r2 = new Rectangulo(3, 4, 2, 3); 
		Rectangulo r3 = new Rectangulo(r1);
		
		listaFig[0] = c2; 
		listaFig[1] = r1; 
		listaFig[2] = r2; 
		listaFig[3] = q2; 
		listaFig[4] = c1; 
		listaFig[5] = q1;
		
		System.out.println("\nLista de Figuras:"); 
		
		for (int i = 0; i < listaFig.length; i++){
			if (listaFig[i] != null) 
				System.out.println(listaFig[i]);
		}

		System.out.println("\n\nCirculos na Lista de Figuras:"); 
		
		for (int i = 0; i < listaFig.length; i++) {
			if (listaFig[i] != null && listaFig[i] instanceof Circulo) 
				System.out.println(listaFig[i]);
		}
		
		System.out.println("\n\nCentro das Figuras:"); 
		
		for (int i = 0; i < listaFig.length; i++) {
			if (listaFig[i] != null) 
				System.out.println(listaFig[i].getCentro());
		}

		System.out.println("\n" + r1 + " É IGUAL " + r2 + "? " + r1.equals(r2));
		System.out.println("\n" + r1 + " É IGUAL " + r3 + "? " + r1.equals(r3)); }
}
