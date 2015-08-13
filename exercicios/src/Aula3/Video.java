package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
/*
 * VideoClube -> Aula 2
 */
public class Video {

	private String titulo;
	private String categoria;
	private int idade;
	/**
	 * IDADE to STRING
	 * 0 - ALL, 1 - M6, 2 - M12, 3 - M16, 4 - M18
	 */
	
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
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public String getCategoria(){
		return this.categoria;
	}
	
	public int getIdadeINT(){
		return this.idade;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return titulo==((Video)b).getTitulo() && categoria==((Video)b).getCategoria() && idade==((Video)b).getIdadeINT();
	}
	
	@Override public String toString(){
		return "T’tulo: "+this.titulo+"\nCategoria: "+this.categoria+"\nIdade: "+idadeToString(this.idade);
	}

}
