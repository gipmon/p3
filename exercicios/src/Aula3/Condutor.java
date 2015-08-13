// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Condutor extends Pessoa{
	private int ncartadeconducao;
	private char categoria;
	
	public Condutor(String name, int cc, Data ddn, int ncartadeconducao, char categoria){
		super(name, cc, ddn);
		if(ncartadeconducao<=0){
			throw new IllegalArgumentException("Numero de carta de condu‹o inv‡lido!");
		}
		this.ncartadeconducao = ncartadeconducao;
		if(!Veiculo.checkCategoria(categoria)){
			throw new IllegalArgumentException("Categoria da carta de condu‹o inv‡lida!");
		}
		this.categoria = categoria;
	}
	
	public int getNCC(){
		return ncartadeconducao;
	}
	
	public char getCategoria(){
		return categoria;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Pessoa)b) && getCategoria() == ((Condutor)b).getCategoria() && getNCC() == ((Condutor)b).getNCC();
	}
	
	@Override public String toString(){
		return super.toString()+"\nNumero de carta de condu‹o: "+ncartadeconducao+"\nCategoria: "+categoria;
	}
}
