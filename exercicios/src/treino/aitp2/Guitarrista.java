// Rafael Ferreira https://github.com/gipmon/p3

package treino.aitp2;

public class Guitarrista extends MusicoDecorador{

	public Guitarrista(MusicoInterface j) {
		super(j);
	}
	
	@Override public String toca(){
		return " guitarra";
	}
	
}
