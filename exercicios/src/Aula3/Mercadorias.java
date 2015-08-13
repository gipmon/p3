package Aula3;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */
public class Mercadorias extends Pesado{
	
	private char tipodecarta = 'C';
	
	public Mercadorias(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>4500){
			throw new IllegalArgumentException("Peso bruto inv�lido!");
		}
		if(lotacao<=0 || lotacao>4){
			throw new IllegalArgumentException("Lota��o inv�lida!");
		}
	}
	
	public String getTipoDeCarta(){
		return Character.toString(tipodecarta);
	}
	
	public String whoAmI(){
		return "Pesado de Mercadorias";
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Pesado)b) && getTipoDeCarta().equals(((Mercadorias)b).getTipoDeCarta());
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de carta: "+tipodecarta;
	}
}
