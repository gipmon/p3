package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Estudante extends Pessoa{
	
	private static int inc_nmec = 100;
	private int nmec;
	Data iDataInsc;
	
	public Estudante(String name, int cc, Data ddn, Data iDataInsc){
		super(name, cc, ddn);
		this.nmec = inc_nmec++;
		this.iDataInsc = iDataInsc;
	}
	
	public String whoAmI(){
		return "Estudante";
	}
	
	public Estudante(String name, int cc, Data ddn){
		this(name, cc, ddn, Data.currentDate());
	}
	
	public Data getiDataInsc(){
		return iDataInsc;
	}
		
	public int getEstNum() {
		return nmec;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Pessoa)b) && nmec == ((Estudante)b).getEstNum() && iDataInsc == ((Estudante)b).getiDataInsc();
	}
	
	@Override public String toString(){
		return super.toString()+", Data de inscrição: "+this.iDataInsc+", Nmec: "+nmec;
	}
	
}