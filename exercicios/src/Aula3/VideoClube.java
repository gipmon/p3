package Aula3;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Map.Entry;
/*
 * VideoClube -> Aula 2
 */
public class VideoClube {
	
	private Hashtable<Integer, Video> catalogo_de_videos = new Hashtable<Integer, Video>();
	private Hashtable<Integer, Rating> rating = new Hashtable<Integer, Rating>();
	//Clientes
	private Hashtable<Integer, Aluno> clientes_alunos = new Hashtable<Integer, Aluno>();
	private Hashtable<Integer, Funcionario> clientes_funcionarios = new Hashtable<Integer, Funcionario>();
	//Clientes
	private Hashtable<Integer, Integer> emprestimos = new Hashtable<Integer, Integer>();
	private Hashtable<Integer, LinkedList<Integer>> historico_de_emprestimos = new Hashtable<Integer, LinkedList<Integer>>();
	private static int quota;
	
	public VideoClube(int q){
		if(q<=0){
			throw new IllegalArgumentException("Quota inv�lida, tem de ser maior do que 0!");
		}
		quota = q;
	}
	
	/**
	 * Add utlizador (Cliente) que neste caso ser� identificado como 
	 * function�rio pois � inserido o NIF.
	 */
	public int addUser(String nome, Data data_insc, int cc, int id, int nif){
		Funcionario value = new Funcionario(nome, data_insc, cc, id, nif);
		clientes_funcionarios.put(Cliente.getNClientes(), value);
		return Cliente.getNClientes();
	}
	
	/**
	 * Add utilizador (Cliente) que ser� distinguido como estudante pois foi inserido
	 * o nome do curso em vez do NIF.
	 */
	public int addUser(String nome, Data data_insc, int cc, int id, String curso){
		Aluno value = new Aluno(nome, data_insc, cc, id, curso);
		clientes_alunos.put(Cliente.getNClientes(), value);
		return Cliente.getNClientes();
	}
	
	public int addVideo(String titulo, String categoria, String idade){
		Video value = new Video(titulo, categoria, idade);
		catalogo_de_videos.put(catalogo_de_videos.size()+1, value);
		return catalogo_de_videos.size();
	}
	
	/**
	 * Este m�todo vai procurar o id do filme com o t�tulo (se existir), depois far� o mesmo para o utilizador.
	 * Caso ambos existam e o filme n�o esteja requisitado o filme � requesitado.
	 */
	public String addEmprestimo(int id_filme, int id_user){
		if(!filmeDisponivel(id_filme)){
			return "O filme n�o est� dispon�vel para aluguer!";
		}else if(userNumberOfVideos(id_user)==quota){
			return "O utilizador atingiu a quota m�xima!";
		}else{
			emprestimos.put(id_filme, id_user);
			
			LinkedList<Integer> lk;
			if(historico_de_emprestimos.containsKey(id_filme)){
				lk = historico_de_emprestimos.get(id_filme);
			}else{
				lk = new LinkedList<Integer>();
			}
			
			if(!lk.contains(id_user)){
				lk.add(id_user);
			}
			
			historico_de_emprestimos.put(id_filme, lk);
			videoRating(id_filme);
			
			if(userNumberOfVideos(id_user)==quota){
				return "Empr�stimo efectuado com sucesso!\nO utilizador atingiu a quota m�xima!";
			}else{
				return "Empr�stimo efectuado com sucesso!";
			}
		}
	}
	
	/**
	 * Faz a devolu��o do filme e regista a vota��o dada pelo utilizador
	 */
	public String outEmprestimo(int id_filme, double rate){
		if(!filmeDisponivel(id_filme)){
			Rating video;
			
			if(!rating.containsKey(id_filme)){
				video = new Rating(rate);
			}else{
				video = rating.get(id_filme);
				video.newRating(rate);
			}
			rating.put(id_filme, video);
			emprestimos.remove(id_filme);
			return "Devolu��o efectuada com sucesso!";
		}else{
			return "N�o existe nenhum v�deo emprestado com esse ID!";
		}
	}
	
	/**
	 * Remove o utilizador e faz a devolu��o sem rating dos v�deos
	 */
	public String removeUser(int id_user){
		boolean exists = false;
		if(clientes_funcionarios.containsKey(id_user)){
			clientes_funcionarios.remove(id_user);
			exists = true;
		}else if(clientes_alunos.containsKey(id_user)){
			clientes_alunos.remove(id_user);
			exists = true;
		}
		if(exists){
			//devolu��o
			for(Entry<Integer, Integer> set : emprestimos.entrySet()){
				if(set.getValue()==id_user){
					emprestimos.remove(set.getKey());
				}
			}
			//remover do hist�rico
			for(Entry<Integer, LinkedList<Integer>> set : historico_de_emprestimos.entrySet()){
				if(set.getValue().contains(id_user)){
					set.getValue().remove((Integer)id_user);
				}
			}
			return "Utilizador removido com sucesso!";
		}else{
			return "O utilizador n�o existe!";
		}
	}
	
	/**
	 * Retorna uma String dos detalhes do utilizador 
	 */
	public String userDetails(int id_user){
		if(clientes_funcionarios.containsKey(id_user)){
			return clientes_funcionarios.get(id_user).toString();
		}else if(clientes_alunos.containsKey(id_user)){
			return clientes_alunos.get(id_user).toString();
		}else{
			return "N�o existe nenhum utilizador com esse ID!";
		}
	}
	
	/**
	 * Remove o v�deo do cat�logo
	 */
	public String removeVideo(int id_video){
		if(!catalogo_de_videos.containsKey(id_video)){
			return "N�o existe nenhum v�deo com esse ID!";
		}else{
			catalogo_de_videos.remove(id_video);
			return "V�deo removido com sucesso!";
		}
	}
	
	/**
	 * Retorna uma String com o hist�rico para determinado v�deo (se ambos existirem)
	 */
	public String listHistoricoVideo(int id_video){
		if(!catalogo_de_videos.containsKey(id_video)){
			return "O v�deo n�o existe no cat�logo!";
		}
		if(historico_de_emprestimos.containsKey(id_video)){
			String out = "";
			LinkedList<Integer> hist = historico_de_emprestimos.get(id_video);
			for(int value : hist.toArray(new Integer[0])){
				out += "S�cio n�: "+value+"\n";
			}
			if(out.length()!=0)
				return "Hist�rico do v�deo \""+catalogo_de_videos.get(id_video).getTitulo()+"\":\n"+out;
		}
		return "N�o existe hist�rico para o v�deo indicado!";
	}
	
	/**
	 * Lista os v�deos que o utilizador tem requisitados
	 */
	public String listVideosUser(int id_user){
		String out = "";
		for(Entry<Integer, Integer> set : emprestimos.entrySet()){
			if(set.getValue()==id_user){
				out += "T�tulo: "+catalogo_de_videos.get(set.getKey()).getTitulo()+"\n";
			}
		}
		if(out.length()==0){
			out =  "N�o existem v�deos alugados deste utilizador!";
		}
		return out;
	}
	
	/**
	 * Hist�rico de empr�stimos para determinado utilizador
	 */
	public String listLastUserVideos(int id_user){
		if(historico_de_emprestimos.size()==0){
			return "N�o existem filmes emprestados";
		}else{
			String out = "";
			for(Entry<Integer, LinkedList<Integer>> set : historico_de_emprestimos.entrySet()){
				if(set.getValue().contains(id_user)){
					out += catalogo_de_videos.get(set.getKey()).getTitulo()+"\n";
				}
			}
			if(out.length()==0){
				out = "N�o existem v�deos no hist�rico para este utilizador!";
			}
			return out;
		}
	}
	
	/**
	 * Retorna uma String dos detalhes do utilizador 
	 */
	public String videoDetails(int id_video){
		if(catalogo_de_videos.containsKey(id_video)){
			String out = catalogo_de_videos.get(id_video).toString();
			out += (this.filmeDisponivel(id_video))?"\nO filme est� dispon�vel!":"\nO filme n�o est� dispon�vel";
			out += "\n"+this.videoRating(id_video);
			return out;
		}else{
			return "N�o existe nenhum filme com esse ID!";
		}
	}
	
	/**
	 * Lista por rate, do mais votado para o menos votado. No entanto a estrutura de dados usada
	 * permite que com pequenas altera��es se inverta a ordem da listagem.
	 */
	public String listByRating(){
		String out = "";
		if(rating.size()==0){
			out += "N�o existem filmes com vota��o!";
		}else{
			TreeMap<Double, Integer> tm = new TreeMap<Double, Integer>();
			for(Entry<Integer, Rating> rate : rating.entrySet()){
				tm.put(rate.getValue().getMedio(), rate.getKey());
			}
			for(Double key : tm.descendingKeySet()){
				out += "ID v�deo: "+tm.get(key)+"; T�tulo: "+catalogo_de_videos.get(tm.get(key)).getTitulo()+"\n";
			}
		}
		return out;
	}
	
	/**
	 * Disponibiliza o rating do v�deo
	 */
	public String videoRating(int id_video){
		if(rating.containsKey(id_video)){
			Rating video = rating.get(id_video);
			return "Rating do v�deo \""+catalogo_de_videos.get(id_video).getTitulo()+"\"\n"+video;
		}else{
			return "Ainda n�o existe nenhum rating para este filme!";
		}
	}
	
	
	/**
	 * Retorna o n�mero de v�deos que um utilizador tem requisitados.
	 */
	private int userNumberOfVideos(int id_user){
		int i = 0;
		for(Entry<Integer, Integer> set : emprestimos.entrySet()){
			if(set.getValue()==id_user){
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Retorna se determinado filme est� ocupado.
	 */
	public boolean filmeDisponivel(int id_filme){
		if(!catalogo_de_videos.containsKey(id_filme)){
			throw new IllegalArgumentException("N�o existe nenhum filme com esse ID!");
		}
		return !emprestimos.containsKey(id_filme);
	}
}
