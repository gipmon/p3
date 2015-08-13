package Aula4.ex41;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Pessoa{
	
	private String name;
	Data ddn;
	private int cc;
	
	public Pessoa(String name, int cc, Data ddn){
		if(name.length() == 0){
			throw new IllegalArgumentException("Nome inv‡lido!");
		}
		this.name = name;
		if(cc <= 0){
			throw new IllegalArgumentException("Nœmero de cart‹o de cidad‹o inv‡lido!");
		}
		this.cc = cc;
		this.ddn = ddn;
	}
	
	public final Data getDDN(){
		return ddn;
	}
	
	public final int getCC(){
		return cc;
	}
	
	public final String getName(){
		return name;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return name.equals(((Pessoa)b).name) && ddn.equals(((Pessoa)b).ddn) && cc==((Pessoa)b).cc;
	}
	
	@Override public String toString(){
		return this.name+", BI: "+this.cc+", Nascido na Data: "+this.ddn;
	}
}
