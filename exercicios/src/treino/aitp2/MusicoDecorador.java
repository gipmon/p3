package treino.aitp2;

public class MusicoDecorador implements MusicoInterface{
	MusicoInterface j;
	
	public MusicoDecorador(MusicoInterface j){
		this.j = j;
	}

	@Override public String toca() {
		return j.toca();
	}
	
}
