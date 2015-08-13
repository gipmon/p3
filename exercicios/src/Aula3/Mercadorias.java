package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Mercadorias extends Pesado{
	
	private char tipodecarta = 'C';
	
	public Mercadorias(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>4500){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>4){
			throw new IllegalArgumentException("Lotação inválida!");
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
