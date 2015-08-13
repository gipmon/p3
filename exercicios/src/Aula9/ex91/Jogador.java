/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex91;

public class Jogador implements JogadorInterface{
	private String name;
	
	public Jogador(String name){
		this.name = name;
	}
	
	public String joga(){
		return "Eu, "+name+" jogo algo.";
	}
	
	public String getName(){
		return name;
	}

	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}
		return name.equals(((Jogador)b).name);
	}
}
