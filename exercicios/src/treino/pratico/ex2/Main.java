// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex2;

public class Main{
	public static void main(String[] args){
		MathCalculator mymath = new Multiply(5, new Sqrt(10)); 
		MathCalculator mymath2 = new Multiply(7, new Sqrt(new Floor(5)));
		System.out.printf("%g\n%g\n", mymath.result(), mymath2.result());
	}	
}
