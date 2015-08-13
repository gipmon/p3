// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
/*
 * VideoClube -> Aula 2
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
	
	public int getNIF(){
		return nif;
	}

	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Cliente)b) && nfunc==((Funcionario)b).getNfunc() && nif==((Funcionario)b).getNIF();
	}
	
	@Override public String toString(){
		return super.toString()+"\nN¼ funcion‡rio: "+nfunc+"\nNIF: "+nif;
	}
}
