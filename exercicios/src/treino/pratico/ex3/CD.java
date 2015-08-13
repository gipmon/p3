// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

public class CD extends Artigo {

	private boolean extra;
	
	public CD(String titulo, double preco, boolean extra) {
		super(titulo, preco);
		this.extra = extra;
	}

	public boolean isExtra(){
		return this.extra;
	}
	
	@Override public String toString(){
		String out = super.toString();
		out += "\t[CD]";
		
		if(extra){
			out += " - contém extras!";
		}
		
		return out+"\n";
	}
}
