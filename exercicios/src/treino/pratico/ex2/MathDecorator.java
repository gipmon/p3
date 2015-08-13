package treino.pratico.ex2;

public class MathDecorator implements MathCalculator{
	private MathCalculator instance;
	
	public MathDecorator(MathCalculator instance){
		this.instance = instance;
	}

	@Override
	public double result() {
		return instance.result();
	}
	
}
