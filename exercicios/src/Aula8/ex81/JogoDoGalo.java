/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex81;

public class JogoDoGalo{
	private int[][] map;  // map[i][j] = 0 => sem bola
	private int nJogadas; 
	protected int jogador;
	
	public JogoDoGalo(){
		map = new int[3][3];
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				map[i][j] = 0;
			}
		}
		this.nJogadas = 0;
		this.jogador = 1;
	}
	
	public boolean posicaoValida(int i, int j){
		return (i >= 1) && (i < 4) && (j >= 1) && (j < 4);
	}
	
	public boolean posicaoVazia(int i, int j){
		if(!posicaoValida(i, j)){
			throw new IllegalArgumentException("Posi‹o inv‡lida!");
		}
	    return this.map[(i - 1)][(j - 1)] == 0;
	}
	
	public void set(int i, int j, int jogador){
		if(!posicaoVazia(i, j)){
			throw new IllegalArgumentException("Posi‹o n‹o est‡ vazia!");
		}
		
	    this.map[(i - 1)][(j - 1)] = jogador;
	    this.nJogadas += 1;
	    
	    if(isFinished() || vencedor()==1 || vencedor()==-1){
	    	throw new JogoTerminado();
	    }
	}

	public boolean isFinished(){
		for(int i=0; i<map.length; i++){
			for(int j=0; j<map[i].length; j++){
				if(map[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean jogadorX(){
		return jogador==1;
	}
	
	public int nJogadas(){
		return nJogadas;
	}
	
	public int vencedor(){
		for(int i = 0; i<map.length; i++){
			if((map[i][0]+map[i][1]+map[i][2])==3){
				return 1;
			}else if((map[i][0]+map[i][1]+map[i][2])==-3){
				return -1;
			}
		}
		for(int j = 0; j<map.length; j++){
			if(map[0][j]+map[1][j]+map[2][j]==3){
				return 1;
			}else if(map[0][j]+map[1][j]+map[2][j]==-3){
				return -1;
			}
		}
		
		if(map[0][0]+map[1][1]+map[2][2]==3){
			return 1;
		}else if(map[0][0]+map[1][1]+map[2][2]==-3){
			return -1;
		}else if(map[0][2]+map[1][1]+map[2][0]==3){
			return 1;
		}else if(map[0][2]+map[1][1]+map[2][0]==-3){
			return -1;
		}
		
		return (isFinished()) ? 0 : 2;
	}

	public class JogoTerminado extends RuntimeException{private static final long serialVersionUID = 1L;};
}