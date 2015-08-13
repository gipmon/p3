package Aula7.ex71;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.Serializable;

public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	
	public final String getCC(){
		return Integer.toString(cc);
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
		return "Nome: "+this.name+"\nData de nascimento: "+this.ddn+"\nCart‹o de cidad‹o: "+this.cc;
	}
}