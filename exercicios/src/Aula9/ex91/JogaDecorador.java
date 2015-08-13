/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex91;

public class JogaDecorador implements JogadorInterface{
	private JogadorInterface j;
	
	public JogaDecorador(JogadorInterface j){
		this.j = j ;
	}
	
	@Override public String joga() {
		return j.joga();
	}

	@Override public String getName() {
		return j.getName();
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}
		return j.equals(((JogaDecorador)b).j);
	}
}
