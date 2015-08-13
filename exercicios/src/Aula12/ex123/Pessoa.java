// Rafael Ferreira https://github.com/gipmon/p3

package Aula12.ex123;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
public class Pessoa{
	
	private String name;
	Data ddn;
	private int cc;
	
	public Pessoa(String name, int cc, Data ddn){
		if(name.length() == 0){
			throw new IllegalArgumentException("Nome inválido!");
		}
		this.name = name;
		if(cc <= 0){
			throw new IllegalArgumentException("Número de cartão de cidadão inválido!");
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
		return "Nome: "+this.name+"\nData de nascimento: "+this.ddn+"\nCartão de cidadão: "+this.cc;
	}
}

