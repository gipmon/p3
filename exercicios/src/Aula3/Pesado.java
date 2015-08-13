// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class Pesado extends Veiculo{
	
	public Pesado(int cilindrada, int potencia, int pesobruto, int lotacao){
		super(cilindrada, potencia, pesobruto, lotacao);
		if(pesobruto>7500){
			throw new IllegalArgumentException("Peso bruto inválido!");
		}
		if(lotacao<=0 || lotacao>150){
			throw new IllegalArgumentException("Lotação inválida!");
		}
	}
	
	public String getTipoDeCarta(){
		return "Tipo de carta de condução não definida!";
	}
	
	public String whoAmI(){
		return "Pesado";
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass() != b.getClass()){
			return false;
		}
		return super.equals((Veiculo)b);
	}
	
	@Override public String toString(){
		return super.toString();
	}
}
