// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Bicicleta extends Veiculo{
	
	private enum Tipo{BTT, Estrada, Urbana, BMX, Infantil, Normal};
	private Tipo tipo;
	
	public Bicicleta(int ano, String corBase, int numRodas, String tipo) {
		super(ano, corBase, numRodas);
		
		try{
			this.tipo = Tipo.valueOf(tipo);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo de bicicleta inv‡lido!\nPermitidos: BTT, Estrada, Urbana, BMX, Infantil, Normal");
		}
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((Bicicleta)b).tipo);
	}
	
	@Override public String toString(){
		return super.toString() + "\nTipo de bicicleta: " + tipo.toString();
	}
}
