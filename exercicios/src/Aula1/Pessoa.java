// Rafael Ferreira https://github.com/gipmon/p3

package Aula1;

public class Pessoa {
	private String nome;
	private int cc;
	private Data datadenascimento;
	
	public Pessoa(String nome, int cc, Data ddn){
		if(nome.length()==0 || cc<=0){
			throw new IllegalArgumentException("Argumentos inv‡lidos");
		}
		this.nome = nome;
		this.cc = cc;
		this.datadenascimento = ddn;
	}
	public String getNome(){
		return this.nome;
	}
	public String getCC(){
		return this.nome;
	}
	public String toString(){
		return "----\nNome: "+this.nome+"\nCart‹o de cidad‹o: "+this.cc+"\nData de nascimento: "+this.datadenascimento.toString()+"\n----"; 
	}
}
