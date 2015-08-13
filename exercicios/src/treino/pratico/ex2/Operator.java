package treino.pratico.ex2;

public class Operator implements MathCalculator{
	
	private double x;
	
	public Operator(double x){
		this.x = x;
	}
	
	@Override
	public double result() {
		return x;
	}

}
