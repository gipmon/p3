package Aula2;

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Cliente {
	
	private static int nclientes = 0;
	
	private Data data_de_nascimento; 
	private String nome;
	private int cc;
	//private int nsocio; n‹o Ž necess‡rio dado que a estrutura de dados usada para o VideoClube faz uso de keys que neste problema s‹o usadas como nsocio
	private int id; // nmec <-> nfunc
	private String curso; // curso se estudante
	private int nif; // nif se funcionario
	
	public Cliente(String nome, Data data_de_nascimento, int cc, int id, int nif){
		set_profile(nome, data_de_nascimento, cc, id);
		this.nif = nif;
	}
	
	public Cliente(String nome, Data data_de_nascimento, int cc, int id, String curso){
		set_profile(nome, data_de_nascimento, cc, id);
		this.curso = curso;
	}
	
	private void set_profile(String nome, Data data_de_nascimento, int cc, int id){
		if(nome.length()==0){
			throw new IllegalArgumentException("Cliente: O nome n‹o pode estar em branco!");
		}
		this.nome = nome;
		this.data_de_nascimento = data_de_nascimento;
		
		if(cc < 0){
			throw new IllegalArgumentException("Cliente: Nœmero de cart‹o de cidad‹o inv‡lido!");
		}
		
		this.cc = cc;
		
		if(id < 0){
			throw new IllegalArgumentException("Cliente: ID inv‡lido (Nmec/ Nfunc)");
		}
		
		nclientes++;
		this.id = id;
	}
	
	public boolean tipo(){ // true -> estudante , false -> funcion‡rio
		return (this.curso != null && this.curso.length()!=0) ? true : false;
	}
	
	public static int getNClientes(){
		return nclientes;
	}
	
	public String toString(){
		if(this.tipo()){ //estudante
			return "Nome: "+this.nome+"\nData de nascimento: "+this.data_de_nascimento.toString()+"\nCart‹o de cidad‹o: "+this.cc+"\nNmec: "+this.id+"\nCurso: "+this.curso;
		}else{
			return "Nome: "+this.nome+"\nData de nascimento: "+this.data_de_nascimento.toString()+"\nCart‹o de cidad‹o: "+this.cc+"\nN¼ funcion‡rio: "+this.id+"\nNIF: "+this.nif;
			
		}
	}
}
