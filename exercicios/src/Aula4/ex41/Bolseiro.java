package Aula4.ex41;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Bolseiro extends Estudante{
	
	private static int nBolseiros = 0;
	private int bolsa;
	
	public Bolseiro(String name, int cc, Data ddn, int bolsa, Data iDataInsc){
		super(name, cc, ddn, iDataInsc);
		if(bolsa<0){
			throw new IllegalArgumentException("Montante da bolsa inv‡lido!");
		}
		this.bolsa = bolsa;
		nBolseiros++;
		this.bolsa = 0;
	}
	
	public Bolseiro(String name, int cc, Data ddn){
		this(name, cc, ddn, 0, Data.currentDate());
	}
	
	public Bolseiro(String name, int cc, Data ddn, int bolsa){
		this(name, cc, ddn, bolsa, Data.currentDate());
	}
	
	public final int getBolsa(){
		return bolsa;
	}
	
	public final static int getNbolseiros(){
		return nBolseiros;
	}
	
	public final void setBolsa(int bolsa){
		this.bolsa = bolsa;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && bolsa == ((Bolseiro)b).bolsa;
	}
	
	@Override public String toString(){
		return super.toString()+", Bolsa: "+bolsa;
	}
}
