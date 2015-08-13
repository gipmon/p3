/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex81;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

import Aula8.ex81.JogoDoGalo.JogoTerminado;

public class BotaoJogada  extends JToggleButton{
	
	private static final long serialVersionUID = 1L;
	private int i;
	private int j;
	private GUI gui;
	
	public BotaoJogada(int i, int j, GUI gui){
		super("");
		this.i = i;
		this.j = j;
		this.gui = gui;
		setVisible(true);
		setFont(new Font("Courier New", 1, 30));
		
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doit();
			}
		};
		
		addActionListener(al);
	}
	
	private void doit(){
		try{
			if(GUI.jogo.jogadorX()){
				setText("X");
			}else{
				setText("0");
			}
			GUI.jogo.set(i, j, (GUI.jogo.jogadorX()) ? 1 : -1);
			this.setEnabled(false);
			GUI.jogo.jogador = (GUI.jogo.jogadorX()) ? -1 : 1;
		}catch(JogoTerminado e){
			gui.fim();
		}catch(IllegalArgumentException e){
			gui.alert(e.getMessage());
		}
	}
	
}

