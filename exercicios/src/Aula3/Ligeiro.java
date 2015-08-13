package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Ligeiro extends Veiculo{
	
	private char tipodecarta = 'B';
	
	public Ligeiro(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>3500){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>9){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String getTipoDeCarta(){
		return Character.toString(tipodecarta);
	}
	
	public String whoAmI(){
		return "Ligeiro";
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Veiculo)b) && getTipoDeCarta().equals(((Ligeiro)b).getTipoDeCarta());
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de carta: "+tipodecarta;
	}
}
