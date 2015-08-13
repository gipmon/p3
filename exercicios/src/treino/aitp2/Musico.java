package treino.aitp2;

public class Musico implements MusicoInterface{
	private String nome;
	
	public Musico(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toca(){
		return "nada";
	}
}
