package Aula4.ex43;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Funcionario extends Cliente{
	
	private int nfunc;
	private int nif;
	
	public Funcionario(String name, Data ddn, int cc, int nfunc, int nif){
		super(name, ddn, cc);
		if(nfunc<=0){
			throw new IllegalArgumentException("Nœmero de funcion‡rio inv‡lido!");
		}
		this.nfunc = nfunc;
		if(nif<=0){
			throw new IllegalArgumentException("NIF inv‡lido!");
		}
		this.nif = nif;
	}
	
	public int getNfunc(){
		return nfunc;
	}
	
	public final int getNIF(){
		return nif;
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && nfunc==((Funcionario)b).nfunc && nif==((Funcionario)b).nif;
	}
	
	@Override public String toString(){
		return super.toString()+"\nN¼ funcion‡rio: "+nfunc+"\nNIF: "+nif;
	}
}
