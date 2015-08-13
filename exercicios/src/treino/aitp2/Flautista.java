// Rafael Ferreira https://github.com/gipmon/p3

package treino.aitp2;

public class Flautista extends MusicoDecorador{

	public Flautista(MusicoInterface j) {
		super(j);
	}
	
	@Override public String toca(){
		return " flauta";
	}
}
