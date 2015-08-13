package Aula3;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */
public class Motociclo extends Veiculo{

	private char tipodecarta = 'A';
	
	public Motociclo(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>1000){
			throw new IllegalArgumentException("Peso bruto inv�lido!");
		}
		if(lotacao<=0 || lotacao>2){
			throw new IllegalArgumentException("Lota��o inv�lida!");
		}
	}
	
	public String getTipoDeCarta(){
		return Character.toString(tipodecarta);
	}
	
	public String whoAmI(){
		return "Motociclo";
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Veiculo)b) && getTipoDeCarta().equals(((Motociclo)b).getTipoDeCarta());
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de carta: "+tipodecarta;
	}
}
