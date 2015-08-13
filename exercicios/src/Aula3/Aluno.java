// Rafael Ferreira https://github.com/gipmon/p3

package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
/*
 * VideoClube -> Aula 2
 * Aluno = Estudante, com diferenças, sem data de inscrição
 */
public class Aluno extends Cliente{
	
	private int nmec;
	private String curso;
	
	public Aluno(String name, Data ddn, int cc, int nmec, String curso){
		super(name, ddn, cc);
		if(nmec<0){
			throw new IllegalArgumentException("Nmec inválido!");
		}
		this.nmec = nmec;
		if(curso.length()==0){
			throw new IllegalArgumentException("Nome de curso inválido!");
		}
		this.curso = curso;
	}
	
	public int getNmec(){
		return nmec;
	}
	
	public String getCurso(){
		return curso;
	}

	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Cliente)b) && nmec==((Aluno)b).getNmec() && curso.equals(((Aluno)b).getCurso());
	}
	
	@Override public String toString(){
		return super.toString()+"\nNmec: "+nmec+"\nCurso: "+curso;		
	}
	
}
