// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex2;

public class Sum extends MathDecorator{

	private double i;
	
	public Sum(MathCalculator instance) {
		super(instance);
	}

	public Sum(double i, MathCalculator instance) {
		super(instance);
		this.i = i;
	}
	
	public Sum(double i, double x){
		super(new Operator(x));
		this.i = i;
	}
	
	@Override public double result(){
		return i + super.result();
	}
	
}
