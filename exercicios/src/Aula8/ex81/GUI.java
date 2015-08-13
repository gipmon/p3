// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex81;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	protected static JogoDoGalo jogo;
	
	public static void main(String[] args){
		jogo = new JogoDoGalo();
		GUI gui = new GUI();
		gui.setDefaultCloseOperation(3);
		gui.setVisible(true);
	}
	
	public GUI(){
		setLocationByPlatform(true);
	    setSize(200, 200);
	    setTitle("Jogo do Galo!");
	    
	    JPanel background = new JPanel();
	    background.setLayout(new GridLayout(3, 3));
	    
	    for(int i=1; i<=3; i++)
	    	for(int j=1; j<=3; j++)
	    		background.add(new BotaoJogada(i, j, this));
	    
	    add(background, "Center");
	}
	
	protected void fim(){
		String result;
		if(jogo.vencedor()==1){
			result = "O jogador X venceu!";
		}else if(jogo.vencedor()==-1){
			result = "O jogador O venceu!";
		}else if(jogo.vencedor()==0){
			result = "Empate!";
		}else{
			return;
		}
		alert(result);
		System.exit(0);
	}
	
	protected void alert(String message){
		JOptionPane.showMessageDialog(getContentPane(), message);
	}
	

}
