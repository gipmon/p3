package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Motorizado extends Veiculo{
	
	private enum Combustivel{Gasoleo, Gasolina, GPL}
	
	private int cilindrada;
	private int potencia;
	private int velMax;
	private double consumo;
	private Combustivel combustivel;
	private String matricula;

    public Motorizado (int ano, String corBase, int numRodas, int cilindrada, int potencia, int velMax, double consumo, String combustivel, String matricula){
    	super(ano, corBase, numRodas);
    	
    	if(cilindrada<=0){
    		throw new IllegalArgumentException("Cilindrada inv‡lida!");
    	}
    	
    	if(potencia<=0){
    		throw new IllegalArgumentException("Potncia inv‡lida!");
    	}
    	
    	if(velMax<=0){
    		throw new IllegalArgumentException("Velocidade m‡xima inv‡lida!");
    	}
    	
    	if(consumo<=0){
    		throw new IllegalArgumentException("Consumo inv‡lido!");
    	}
    	
    	this.cilindrada = cilindrada;
    	this.potencia = potencia;
    	this.velMax = velMax;
    	this.consumo = consumo;
    	
    	try{
    		this.combustivel = Combustivel.valueOf(combustivel);
    	}catch(IllegalArgumentException e){
    		throw new IllegalArgumentException("Combust’vel inv‡lido!\nPermitidos:Gasoleo, Gasolina, GPL");
    	}
    	
    	this.matricula = matricula;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getVelMax() {
        return velMax;
    }

    public double getConsumo() {
    	return consumo;
    }

    public String getCombustivel() {
    	return combustivel.toString();
    }
    
    public String getMatricula(){
    	return matricula;
    }
    
    @Override public boolean equals(Object b){
    	return super.equals(b) && cilindrada==((Motorizado)b).cilindrada && potencia==((Motorizado)b).potencia && velMax==((Motorizado)b).velMax && consumo==((Motorizado)b).consumo && combustivel.equals(((Motorizado)b).combustivel) && matricula.equals(((Motorizado)b).matricula);
    }
    
    @Override public String toString(){
    	return super.toString()+"\nCilindrada: "+cilindrada+"\nPotncia: "+potencia+"\nVelocidade m‡xima: "+velMax+"\nConsumo: "+consumo+"\nCombust’vel: "+combustivel.toString()+"\nMatr’cula: "+matricula;
    }
}
