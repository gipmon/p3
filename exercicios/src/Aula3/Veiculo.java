package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Veiculo {
	
	private int cilindrada;
	private int potencia;
	private int pesobruto;
	private int lotacao;
	
	public Veiculo(int cilindrada, int potencia, int pesobruto, int lotacao){
		if(cilindrada<=0){
			throw new IllegalArgumentException("Cilindrada incorreta!");
		}
		this.cilindrada = cilindrada;
		if(potencia<=0){
			throw new IllegalArgumentException("Potncia incorreta!");
		}
		this.potencia = potencia;
		this.pesobruto = pesobruto;
		this.lotacao = lotacao;
	}
	
	public int getCilindrada(){
		return cilindrada;
	}
	
	public int getPotencia(){
		return potencia;
	}
	
	public int getPesoBruto(){
		return pesobruto;
	}
	
	public int getLotacao(){
		return lotacao;
	}
	
	public String whoAmI(){
		return "Veiculo";
	}
	
	public static boolean checkCategoria(char categoria){
		if(categoria == 'A' || categoria == 'B' || categoria == 'C' || categoria == 'D'){
			return true;
		}else{
			return false;
		}
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return cilindrada==((Veiculo)b).getCilindrada() && potencia==((Veiculo)b).getPotencia() && pesobruto==((Veiculo)b).getPesoBruto() && lotacao==((Veiculo)b).getLotacao();
	}
	
	@Override public String toString(){
		return "Cilindrada: "+cilindrada+"\nPotncia: "+potencia+"\nPeso bruto: "+pesobruto+"\nLota‹o: "+lotacao;
	}
}