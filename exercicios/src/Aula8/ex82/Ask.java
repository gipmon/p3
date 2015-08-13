/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex82;

public class Ask {
	private String level;
	private String ask;
	private String urlImage;
	private String[] options;
	private String answer;
	
	public Ask(String level, String ask, String urlImage, String[] options, String answer){
		this.level = level;
		this.ask = ask;
		this.urlImage = urlImage.replace(":", "/");
		this.options = options;
		this.answer = answer;
	}
	
	@Override public String toString(){
		return ask;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}else{
			return level.equals(((Ask)b).level) && ask.equals(((Ask)b).ask) &&
					urlImage.equals(((Ask)b).urlImage) && options.equals(((Ask)b).options)
					&& answer.equals(((Ask)b).answer);
		}
	}
	
	public String getImage(){
		return urlImage;
	}
	
	public String getLevel(){
		return level;
	}
	
	public String[] getOptions(){
		return options;
	}
	
	public String getAnswer(){
		return answer;
	}
	
}
