// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex2;

public class Multiply extends MathDecorator{
	
	private double i;
	
	public Multiply(MathCalculator instance) {
		super(instance);
	}

	public Multiply(double i, MathCalculator instance) {
		super(instance);
		this.i = i;
	}
	
	public Multiply(double i, double x){
		super(new Operator(x));
		this.i = i;
	}
	
	@Override public double result(){
		return i * super.result();
	}
}
