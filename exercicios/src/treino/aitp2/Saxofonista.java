package treino.aitp2;

public class Saxofonista extends MusicoDecorador{

	public Saxofonista(MusicoInterface j) {
		super(j);
	}

	@Override public String toca(){
		return " saxofone";
	}
}
