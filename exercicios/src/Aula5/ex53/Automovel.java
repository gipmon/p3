// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Automovel extends Motorizado{
	
	private enum Tipo{Normal, Familiar, Comercial, Desportivo, Tunning, SuperCar, Conversivel, Jipe};
	private Tipo tipo;
	private String marca;
	
	public Automovel(int ano, String corBase, int numRodas, int cilindrada,
			int potencia, int velMax, double consumo, String marca, String combustivel,
			String matricula, String tipo){
		
		super(ano, corBase, numRodas, cilindrada, potencia, velMax, consumo,
			  combustivel, matricula);
		
		try{
			this.tipo = Tipo.valueOf(tipo);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo de autom—vel inv‡lido!\nPermitidos: Normal, Familiar, Comercial, Desportivo, Tunning, SuperCar, Conversivel, Jipe");
		}
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((Automovel)b).tipo);
	}
	
	@Override public String toString(){
		return super.toString() + "\nMarca: "+marca+"\nTipo de autom—vel: " + tipo.toString();
	}
}
