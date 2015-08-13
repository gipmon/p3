package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Moto extends Motorizado{
	
	private enum Tipo{Scooter, Desportiva, Custom, Chopper, TT, Street, Underbone, Normal};
	
	private Tipo tipo;
	
	public Moto(int ano, String corBase, int numRodas, int cilindrada,
			int potencia, int velMax, double consumo, String combustivel,
			String matricula, String tipo) {
		super(ano, corBase, numRodas, cilindrada, potencia, velMax, consumo,
				combustivel, matricula);
		try{
			this.tipo = Tipo.valueOf(tipo);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo de moto inv‡lido!\nPermitidos: Scooter, Desportiva, Custom, Chopper, TT, Street, Underbone, Normal");
		}
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((Moto)b).tipo);
	}
	
	@Override public String toString(){
		return super.toString() + "\nTipo de moto: " + tipo.toString();
	}

}
