package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Passageiros extends Pesado{

	private char tipodecarta = 'D';
	
	public Passageiros(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>7000){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>150){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String getTipoDeCarta(){
		return Character.toString(tipodecarta);
	}
	
	public String whoAmI(){
		return "Pesado de Passageiros";
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Pesado)b) && getTipoDeCarta().equals(((Passageiros)b).getTipoDeCarta());
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de carta: "+tipodecarta;
	}
}
