// Rafael Ferreira https://github.com/gipmon/p3

package Aula2;

/**
 * @author Ant—nio Ferreira
 * nmec 67405
 */
public class Video{
	
	private static int nvideos = 0;
	
	//private int id; //n‹o Ž necess‡rio dado que a estrutura de dados usada para o VideoClube permite user a key como id
	private String titulo;
	private String categoria;
	/**
	 * IDADE to STRING
	 * 0 - ALL, 1 - M6, 2 - M12, 3 - M16, 4 - M18
	 */
	private int idade;
	
	public Video(String titulo, String categoria, String idade){
		if(titulo.length()==0){
			throw new IllegalArgumentException("V’deo: T’tulo inv‡lido!");
		}
		this.titulo = titulo;
		
		if(categoria.length()==0){
			throw new IllegalArgumentException("V’deo: Categoria inv‡lida!");
		}
		this.categoria = categoria;
		
		this.idade = stringToIdade(idade);
		nvideos++;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public int stringToIdade(String str){
		if(str.equals("ALL")){
			return 0;
		}
		if(str.equals("M6")){
			return 1;
		}
		if(str.equals("M12")){
			return 2;
		}
		if(str.equals("M16")){
			return 3;
		}
		if(str.equals("M18")){
			return 4;
		}
		throw new IllegalArgumentException("V’deo: String idade inv‡lida!");
	}
	
	public String idadeToString(int idade){
		if(idade<0 || idade>4){
			throw new IllegalArgumentException("V’deo: Inteiro idade inv‡lida!");
		}
		if(idade==0){
			return "ALL";
		}
		if(idade==1){
			return "M6";
		}
		if(idade==2){
			return "M12";
		}
		if(idade==3){
			return "M16";
		}
		return "M18";
	}
	
	public static int getNVideos(){
		return nvideos;
	}
	
	public String toString(){
		return "T’tulo: "+this.titulo+"\nCategoria: "+this.categoria+"\nIdade: "+idadeToString(this.idade);
	}
}
