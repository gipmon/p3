// Rafael Ferreira https://github.com/gipmon/p3

package Aula6.ex1;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */

public class PratoDieta extends Prato{
	
	private static final long serialVersionUID = 1L;
	private double limitMaxCalorias;

	public PratoDieta(String nome, double limitMaxCalorias) {
		super(nome);
		if(getCalorias()>limitMaxCalorias){
			throw new IllegalArgumentException("O prato ultrapassou o limite de calorias!");
		}
		this.limitMaxCalorias = limitMaxCalorias;
	}
	
	public double getLimitCalorias(){
		return limitMaxCalorias;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && limitMaxCalorias == (((PratoDieta)b).limitMaxCalorias);
	}
	
	@Override public String toString(){
		return "Dieta "+super.toString();
	}
}
