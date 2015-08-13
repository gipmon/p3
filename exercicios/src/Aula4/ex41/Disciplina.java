package Aula4.ex41;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Disciplina{
	private String nome;
	private String area_cientifica;
	private int ects;
	private Professor responsavel;
	private LinkedHashMap<Integer, Estudante> array = new LinkedHashMap<Integer, Estudante>();
	
	public Disciplina(String nome, String area_cientifica, int ects, Professor responsavel){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome da disciplina inválido!");
		}
		if(area_cientifica.length()==0){
			throw new IllegalArgumentException("Area Científica inválido!");
		}
		if(ects<0){
			throw new IllegalArgumentException("ECTS inválidos!");
		}
		this.nome = nome;
		this.area_cientifica = area_cientifica;
		this.ects = ects;
		this.responsavel = responsavel;
	}
	
	public final boolean addAluno(Estudante est){
		if(array.containsValue(est)){
			return false;
		}
		array.put(est.getNMec(), est);
		return true;
	}
	
	public final boolean delAluno(int nMec){
		if(!array.containsKey(nMec)){
			return false;
		}
		array.remove(nMec);
		return true;
	}
	
	public boolean alunoInscrito(int nMec){
		return array.containsKey(nMec);
	}
	
	public final int numAlunos(){
		return array.size();
	}
	
	public Estudante[] getAlunos(){
		Estudante[] est = new Estudante[array.size()];
		int i = 0;
		for(Entry<Integer, Estudante> set : array.entrySet()){
			est[i++] = set.getValue();
		}
		return est;
	}
	
	public Estudante[] getAlunos(String tipo){
		LinkedList<Estudante> est = new LinkedList<Estudante>();
		for(Entry<Integer, Estudante> set : array.entrySet()){
			if(set.getValue().getClass().getSimpleName().equals(tipo)){
				est.add(set.getValue());
			}
		}
		return est.toArray(new Estudante[0]);
	}
	
	@Override public String toString(){
		return "Disciplina: "+nome+" ( "+ects+" ECTS) da "+area_cientifica+"\nResponsável: PROFESSOR: "+responsavel+"\nExistem "+numAlunos()+" Alunos Inscritos";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * responsavel não comparado
	 */
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(b.getClass()!=getClass()){
			return false;
		}
		return nome.equals(((Disciplina)b).nome) && area_cientifica.equals(((Disciplina)b).area_cientifica) && ects==((Disciplina)b).ects;
	}

}
