package treino.pratico.ex2;

public class Sqrt extends MathDecorator{
 	
	public Sqrt(MathCalculator instance) {
		super(instance);
	}
	
	public Sqrt(double i){
		super(new Operator(i));
	}
	
	@Override public double result(){
		return Math.sqrt(super.result());
	}
	
}
