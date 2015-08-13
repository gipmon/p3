// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class BicicletaPolicia extends Bicicleta implements Policia{

	Tipo tipo;
	String ID;
	
	public BicicletaPolicia(int ano, String corBase, int numRodas, String tipoBicicleta, String tipoPolicia, String ID) {
		super(ano, corBase, numRodas, tipoBicicleta);
		
		try{
			tipo = Tipo.valueOf(tipoPolicia);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Tipo de Bicicleta Pol’cia inv‡lida!\nPermitidos: INEM, Bombeiros, GNR, PSP, PJ");
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
		return super.equals(b) && tipo.equals(((BicicletaPolicia)b).tipo) && ID.equals(((BicicletaPolicia)b).ID);
	}
	
	@Override public String toString(){
		return super.toString()+"\nTipo de Pol’cia: "+this.tipo.toString()+"\nIdentificador interno: "+this.ID;
	}
}
