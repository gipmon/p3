// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Pessoa {
	
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
	
	public String whoAmI(){
		return "Pessoa";
	}
	
	public Data getDDN(){
		return ddn;
	}
	
	public int getCC(){
		return cc;
	}
	
	public String getName(){
		return name;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return name.equals(((Pessoa)b).getName()) && ddn.equals(((Pessoa)b).getDDN()) && cc==((Pessoa)b).getCC();
	}
	
	@Override public String toString(){
		return "Nome: "+this.name+"\nData de nascimento: "+this.ddn+"\nCart‹o de cidad‹o: "+this.cc;
	}
}
