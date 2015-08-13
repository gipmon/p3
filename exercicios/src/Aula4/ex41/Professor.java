package Aula4.ex41;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Professor extends Pessoa{
	
	private static int nfuncCOUNTER = 1;
	
	private int nfunc;
	private Data dataAdmissao;
	
	public Professor(String name, int cc, Data ddn, int nfunc, Data dataAdmissao){
		super(name, cc, ddn);
		if(nfunc>0 || nfuncCOUNTER>=nfunc){
			throw new IllegalArgumentException("Nœmero de funcion‡rio inv‡lido!");
		}
		this.nfunc = nfunc;
		this.dataAdmissao = dataAdmissao;
		nfuncCOUNTER++;
	}
	
	public Professor(String name, int cc, Data ddn){
		super(name, cc, ddn);
		this.nfunc = nfuncCOUNTER++;
		this.dataAdmissao = Data.currentDate();
	}
	
	@Override public String toString(){
		return getName()+", BI: "+getCC()+", Nascido na Data: "+getDDN()+", Nfunc: "+nfunc+", Admitido na Data: "+dataAdmissao;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && ((Professor)b).nfunc == nfunc && ((Professor)b).dataAdmissao.equals(dataAdmissao);
	}
	
}
