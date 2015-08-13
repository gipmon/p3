// Rafael Ferreira https://github.com/gipmon/p3

package Aula4.ex43;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Estudante extends Cliente{
	
	private int nmec;
	private String curso;
	
	public Estudante(String name, Data ddn, int cc, int nmec, String curso){
		super(name, ddn, cc);
		if(nmec<0){
			throw new IllegalArgumentException("Nmec inv‡lido!");
		}
		this.nmec = nmec;
		if(curso.length()==0){
			throw new IllegalArgumentException("Nome de curso inv‡lido!");
		}
		this.curso = curso;
	}
	
	public int getNmec(){
		return nmec;
	}
	
	public final String getCurso(){
		return curso;
	}

	@Override public boolean equals(Object b){
		return super.equals(b) && nmec==((Estudante)b).nmec && curso.equals(((Estudante)b).curso);
	}
	
	@Override public String toString(){
		return super.toString()+"\nNmec: "+nmec+"\nCurso: "+curso;		
	}
	
}
