package Aula4.ex41;
/**
 * @author Ant—nio Rafael Ferreira
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
	
	public Estudante(String name, int cc, Data ddn){
		this(name, cc, ddn, Data.currentDate());
	}
	
	public final Data getiDataInsc(){
		return iDataInsc;
	}
		
	public final int getNMec(){
		return nmec;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && nmec == ((Estudante)b).nmec && iDataInsc.equals(((Estudante)b).iDataInsc);
	}
	
	@Override public String toString(){
		return super.toString()+", Estudante Nmec: "+nmec+", Inscrito em Data: "+this.iDataInsc;
	}
	
}