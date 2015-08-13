// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex2;

public class Floor extends MathDecorator{
 
	public Floor(MathCalculator instance) {
		super(instance);
	}

	public Floor(double i){
		super(new Operator(i));
	}
	
	@Override public double result(){
		return Math.floor(super.result());
	}

}
