// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class MotoPolicia extends Moto implements Policia{
	
	Tipo tipo;
	String ID;
	
	public MotoPolicia(int ano, String corBase, int numRodas, int cilindrada,
			int potencia, int velMax, int consumo, String combustivel,
			String matricula, String tipoMoto, String tipoPolicia, String ID) {
		
		super(ano, corBase, numRodas, cilindrada, potencia, velMax, consumo,
				combustivel, matricula, tipoMoto);
		
		try{
			this.tipo = Tipo.valueOf(tipoPolicia);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo de Moto Pol’cia inv‡lida!\nPermitidos: INEM, Bombeiros, GNR, PSP, PJ");
		}
		
		setID(ID);
	}
	
	@Override public void setID(String ID){
		if(ID.length()==0){
			throw new IllegalArgumentException("Identificador interno inv‡lido!");
		}
		this.ID = ID;
	}
	
	@Override public String getID(){
		return ID;
	}
	
	@Override public String getTipo() {
		return tipo.toString();
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && tipo.equals(((MotoPolicia)b).tipo) && ID.equals(((MotoPolicia)b).ID);
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de Pol’cia: "+this.tipo.toString()+"\nIdentificador interno: "+this.ID;
	}
}
