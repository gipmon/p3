// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Veiculo implements Comparable{
	
	private enum Cor{
		Vermelho, Laranja, Violeta, Azul, Ciano, Verde, Amarelo, Preto, Branco
	};
	
	private int ano;
	private Cor corBase;
	private int numRodas;
	
	public Veiculo(int ano, String corBase, int numRodas){
		if(ano<=0){
			throw new IllegalArgumentException("Ano do ve’culo inv‡lido!");
		}
		
		if(numRodas <= 0){
			throw new IllegalArgumentException("Nœmero de rodas inv‡lido!");
		}
		
		this.ano = ano;
		this.numRodas = numRodas;
		
		try{
			this.corBase = Cor.valueOf(corBase);
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Cor base do ve’culo inv‡lida!\nApenas s‹o premitidas as seguintes cores: Vermelho, Laranja, Violeta, Azul, Ciano, Verde, Amarelo, Preto, Branco.");
		}
	}
	
	@Override public int compareTo(Object b){
		if(this.ano<((Veiculo)b).ano){
			return -1;
		}else if(this.ano>((Veiculo)b).ano){
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return ano==((Veiculo)b).ano && corBase.equals(((Veiculo)b).corBase) && numRodas==((Veiculo)b).numRodas;
	}
	
	@Override public String toString(){
		return getClass().getSimpleName()+"\nAno: "+this.ano+"\nCor: "+this.corBase.toString()+"\nNœmero de rodas: "+this.numRodas;
	}
}