// Rafael Ferreira https://github.com/gipmon/p3

package Aula2;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author António Ferreira
 * nmec 67405
 */
public class VideoClube{
	
	private Hashtable<Integer, Video> catalogo_de_videos = new Hashtable<Integer, Video>();
	private Hashtable<Integer, Cliente> utilizadores = new Hashtable<Integer, Cliente>();
	private Hashtable<Integer, Integer> emprestimos = new Hashtable<Integer, Integer>();
	private Hashtable<Integer, LinkedList<Integer>> historico_de_emprestimos = new Hashtable<Integer, LinkedList<Integer>>();
	private Hashtable<Integer, Rating> rating = new Hashtable<Integer, Rating>();
	private static int quota;
	
	public VideoClube(int q){
		if(q<=0){
			throw new IllegalArgumentException("Quota inválida, tem de ser maior do que 0!");
		}
		quota = q;
	}
	
	/**
	 * Add utlizador (Cliente) que neste caso será identificado como 
	 * functionário pois é inserido o NIF.
	 */
	public int addUser(String nome, Data data_insc, int cc, int id, int nif){
		Cliente value = new Cliente(nome, data_insc, cc, id, nif);
		utilizadores.put(Cliente.getNClientes(), value);
		return Cliente.getNClientes();
	}
	
	
	/**
	 * Add utilizador (Cliente) que será distinguido como estudante pois foi inserido
	 * o nome do curso em vez do NIF.
	 */
	public int addUser(String nome, Data data_insc, int cc, int id, String curso){
		Cliente value = new Cliente(nome, data_insc, cc, id, curso);
		utilizadores.put(Cliente.getNClientes(), value);
		return Cliente.getNClientes();
	}
	
	public int addVideo(String titulo, String categoria, String idade){
		Video value = new Video(titulo, categoria, idade);
		catalogo_de_videos.put(Video.getNVideos(), value);
		return Video.getNVideos();
	}
	
	/**
	 * Este método vai procurar o id do filme com o título (se existir), depois fará o mesmo para o utilizador.
	 * Caso ambos existam e o filme não esteja requisitado o filme é requesitado.
	 */
	public String addEmprestimo(int id_filme, int id_user){
		if(!filmeDisponivel(id_filme)){
			return "O filme não está disponível para aluguer!";
		}else if(userNumberOfVideos(id_user)==quota){
			return "O utilizador atingiu a quota máxima!";
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
				return "Empréstimo efectuado com sucesso!\nO utilizador atingiu a quota máxima!";
			}else{
				return "Empréstimo efectuado com sucesso!";
			}
		}
	}
	
	/**
	 * Faz a devolução do filme e regista a votação dada pelo utilizador
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
			return "Devolução efectuada com sucesso!";
		}else{
			return "Não existe nenhum vídeo emprestado com esse ID!";
		}
	}
	
	/**
	 * Remove o utilizador
	 */
	public String removeUser(int id_user){
		if(utilizadores.get(id_user) == null){
			return "Não existe nenhum utilizador com esse número de sócio!";
		}else{
			utilizadores.remove(id_user);
			return "Utilizador removido com sucesso!";
		}
	}
	
	/**
	 * Remove o vídeo do catálogo
	 */
	public String removeVideo(int id_video){
		if(!catalogo_de_videos.containsKey(id_video)){
			return "Não existe nenhum vídeo com esse ID!";
		}else{
			catalogo_de_videos.remove(id_video);
			return "Vídeo removido com sucesso!";
		}
	}
	
	/**
	 * Retorna uma String com o histórico para determinado vídeo (se ambos existirem)
	 */
	public String listHistoricoVideo(int id_video){
		if(!catalogo_de_videos.containsKey(id_video)){
			return "O vídeo não existe no catálogo!";
		}
		if(historico_de_emprestimos.containsKey(id_video)){
			String out = "Histórico do vídeo \""+catalogo_de_videos.get(id_video).getTitulo()+"\":\n";
			LinkedList<Integer> hist = historico_de_emprestimos.get(id_video);
			for(int value : hist.toArray(new Integer[0])){
				out += "Sócio nº: "+value+"\n";
			}
			return out;
		}
		return "Não existe histórico para o vídeo indicado!";
	}
	
	/**
	 * Lista os vídeos que o utilizador tem requisitados
	 */
	public String listVideosUser(int id_user){
		String out = "";
		for(Entry<Integer, Integer> set : emprestimos.entrySet()){
			if(set.getValue()==id_user){
				out += "Título: "+catalogo_de_videos.get(set.getKey()).getTitulo()+"\n";
			}
		}
		if(out.length()==0){
			out =  "Não existem vídeos alugados deste utilizador!";
		}
		return out;
	}
	
	/**
	 * Histórico de empréstimos para determinado utilizador
	 */
	public String listLastUserVideos(int id_user){
		if(historico_de_emprestimos.size()==0){
			return "Não existem filmes emprestados";
		}else{
			String out = "";
			for(Entry<Integer, LinkedList<Integer>> set : historico_de_emprestimos.entrySet()){
				if(set.getValue().contains(id_user)){
					out += catalogo_de_videos.get(set.getKey()).getTitulo()+"\n";
				}
			}
			if(out.length()==0){
				out = "Não existem vídeos no histórico para este utilizador!";
			}
			return out;
		}
	}
	
	/**
	 * Retorna uma String dos detalhes do utilizador 
	 */
	public String userDetails(int id_user){
		if(utilizadores.containsKey(id_user)){
			return utilizadores.get(id_user).toString();
		}else{
			return "Não existe nenhum utilizador com esse ID!";
		}
	}

	/**
	 * Retorna uma String dos detalhes do utilizador 
	 */
	public String videoDetails(int id_video){
		if(catalogo_de_videos.containsKey(id_video)){
			String out = catalogo_de_videos.get(id_video).toString();
			out += (this.filmeDisponivel(id_video))?"\nO filme está disponível!":"\nO filme não está disponível";
			out += "\n"+this.videoRating(id_video);
			return out;
		}else{
			return "Não existe nenhum filme com esse ID!";
		}
	}
	
	/**
	 * Lista por rate, do mais votado para o menos votado. No entanto a estrutura de dados usada
	 * permite que com pequenas alterações se inverta a ordem da listagem.
	 */
	public String listByRating(){
		String out = "";
		if(rating.size()==0){
			out += "Não existem filmes com votação!";
		}else{
			TreeMap<Double, Integer> tm = new TreeMap<Double, Integer>();
			for(Entry<Integer, Rating> rate : rating.entrySet()){
				tm.put(rate.getValue().getMedio(), rate.getKey());
			}
			for(Double key : tm.descendingKeySet()){
				out += "ID vídeo: "+tm.get(key)+"; Título: "+catalogo_de_videos.get(tm.get(key)).getTitulo()+"\n";
			}
		}
		return out;
	}
	
	/**
	 * Disponibiliza o rating do vídeo
	 */
	public String videoRating(int id_video){
		if(rating.containsKey(id_video)){
			Rating video = rating.get(id_video);
			return "Rating do vídeo \""+catalogo_de_videos.get(id_video).getTitulo()+"\"\nRating total: "+video.getTotal()+"\nRating médio: "+video.getMedio();
		}else{
			return "Ainda não existe nenhum rating para este filme!";
		}
	}
	
	
	/**
	 * Retorna o número de vídeos que um utilizador tem requisitados.
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
	 * Retorna se determinado filme está ocupado.
	 */
	public boolean filmeDisponivel(int id_filme){
		if(!catalogo_de_videos.containsKey(id_filme)){
			throw new IllegalArgumentException("Não existe nenhum filme com esse ID!");
		}
		return !emprestimos.containsKey(id_filme);
	}
}
