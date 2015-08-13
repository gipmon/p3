// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

public class MP3 extends Artigo implements Playable{

	private int mb;
	
	public MP3(String titulo, double preco, int mb) {
		super(titulo, preco);
		this.mb = mb;
	}
	
	public int getMB(){
		return this.mb;
	}
	
	@Override public String toString(){
		return super.toString() + "\t[MP3] - "+mb+" mb\n";
	}

	@Override public void play() {
		System.out.println("Tocando x)");
	}

}
