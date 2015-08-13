package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Test33{
	public static void main(String[] args){
		Circulo c1 = new Circulo(2);
		Circulo c2 = new Circulo(1, 3, 2); 
		Circulo c3 = new Circulo(c2);
	
		System.out.println(c1 + "\n");
		System.out.println(c3 + "\n");
		
		Quadrado q1 = new Quadrado(2); 
		Quadrado q2 = new Quadrado(3, 4, 2); 
		Quadrado q3 = new Quadrado(q2);
		
		System.out.println(q1 +  "\n");
		System.out.println(q3 +  "\n");
		
		Rectangulo r1 = new Rectangulo(2, 3); 
		Rectangulo r2 = new Rectangulo(3, 4, 2, 3); 
		Rectangulo r3 = new Rectangulo(r2);
		
		System.out.println(r1 + "\n");
		System.out.println(r3 + "\n");
		
	}
}