// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex2;

public class Divide extends MathDecorator{
	
	private double i;
	
	public Divide(MathCalculator instance) {
		super(instance);
	}

	public Divide(double i, MathCalculator instance) {
		super(instance);
		this.i = i;
	}
	
	public Divide(double i, double x){
		super(new Operator(x));
		this.i = i;
	}
	
	@Override public double result(){
		return i / super.result();
	}
	
}
