package Aula5.ex52;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public abstract class Calcado{
	
	private String nome;
	private String fabricante;
	private double preco;
	
	public Calcado(String nome, String fabricante, double preco){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome inv‡lido!");
		}
		if(fabricante.length()==0){
			throw new IllegalArgumentException("Fabricante inv‡lido!");
		}
		if(preco < 0){
			throw new IllegalArgumentException("Preo inv‡lido!");
		}
		this.nome = nome;
		this.fabricante = fabricante;
		this.preco = preco;
	}
	
	public final String getNome(){
		return nome;
	}
	
	public final String getFabricante(){
		return fabricante;
	}
	
	public final double getPreco(){
		return preco;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(b.getClass()!=getClass()){
			return false;
		}
		return nome.equals(((Calcado)b).nome) && fabricante.equals(((Calcado)b).fabricante)
				&& preco == ((Calcado)b).preco;
	}
	
	@Override public String toString(){
		return getClass().getSimpleName()+"\nNome: "+nome+"\nFabricante: "+fabricante+"\nPreo: "+preco;
	}
}
