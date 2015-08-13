// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex131;

import java.io.Serializable;

public class Regiao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private int populacao;
	
	public Regiao(String nome, int populacao){
		this.nome = nome;
		this.setPopulacao(populacao);
	}
	
	public String getNome() {
		return nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}else{
			return (((Regiao)b).nome).equals(nome) &&
					(((Regiao)b).populacao)==populacao;
		}
	}
	
	@Override public String toString(){
		return nome+" "+populacao+"\n";
	}
}
