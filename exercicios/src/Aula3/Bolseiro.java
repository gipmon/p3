// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Bolseiro extends Estudante{
	
	private int bolsa;
	
	public Bolseiro(String name, int cc, Data ddn, int bolsa, Data iDataInsc){
		super(name, cc, ddn, iDataInsc);
		if(bolsa<0){
			throw new IllegalArgumentException("Montante da bolsa inv‡lido!");
		}
		this.bolsa = bolsa;
	}
	
	public Bolseiro(String name, int cc, Data ddn){
		this(name, cc, ddn, 0, Data.currentDate());
	}
	
	public Bolseiro(String name, int cc, Data ddn, int bolsa){
		this(name, cc, ddn, bolsa, Data.currentDate());
	}
	
	public String whoAmI(){
		return "Bolseiro";
	}
	
	public int getBolsa(){
		return bolsa;
	}
	
	public void setBolsa(int bolsa){
		this.bolsa = bolsa;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Estudante)b) && bolsa == ((Bolseiro)b).getBolsa();
	}
	
	@Override public String toString(){
		return super.toString()+", Bolsa: "+bolsa;
	}
}
