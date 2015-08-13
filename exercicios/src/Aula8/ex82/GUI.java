// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex82;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private ButtonGroup options;
	private Ask ask;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JPanel askPanel;
	private QQSM QQSM_master;
	
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
            	GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
	}
	
	public GUI(){
		super("Quem quer ser Milionário !?");

		QQSM_master = new QQSM(new File("questions.txt"));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.getContentPane().add(graphicAsk());
	
	}
	
	private JPanel graphicAsk(){
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(2,2));
		pane.setVisible(true);
		
		//get ask
		ask = (QQSM_master).getRandomAsk();
		
		//image
		JPanel pictureBox = new JPanel();
		pictureBox.setVisible(true);
		try {
			BufferedImage picture = ImageIO.read(new File(ask.getImage()));
			JLabel pic = new JLabel(new ImageIcon(picture));
			pictureBox.add(pic);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pane.add(pictureBox);
		
		askPanel = new JPanel();
		//Ask right
		JLabel labelAsk = new JLabel(ask.toString());
		labelAsk.setAlignmentY(CENTER_ALIGNMENT);
		labelAsk.setAlignmentX(CENTER_ALIGNMENT);
		labelAsk.setVisible(true);
		askPanel.setLayout(new GridLayout(2, 1));
		
		askPanel.add(labelAsk);
		//Dificulty
		JLabel labelDif = new JLabel("Pergunta: "+QQSM_master.getN()+", Prémio: "+QQSM_master.getPrize()+"€");
		labelDif.setAlignmentY(CENTER_ALIGNMENT);
		labelDif.setAlignmentX(CENTER_ALIGNMENT);
		labelDif.setVisible(true);
		
		askPanel.add(labelDif);
		
		askPanel.setVisible(true);
		pane.add(askPanel);
		
		//Answer options
		JPanel optionsP = new JPanel();
		optionsP.setVisible(true);
		options = new ButtonGroup();
		for(String askText : ask.getOptions()){
			JRadioButton radio = new JRadioButton(askText);
			options.add(radio);
			optionsP.add(radio);
		}
		
		pane.add(optionsP);
		
		//Buttons
		JPanel buttonsGroup = new JPanel();
		buttonsGroup.setVisible(true);
		buttonsGroup.setLayout(new GridLayout(2, 1));
		
		//1º group
		ButtonGroup btnGroup1 = new ButtonGroup();
		JPanel bttnG1 = new JPanel();
		bttnG1.setVisible(true);
		if(QQSM_master.getPublico()){
			b1 = new JButton("Ajuda Público");
			btnGroup1.add(b1);
			bttnG1.add(b1);
		}
		if(QQSM_master.getCall()){
			b2 = new JButton("Telefone");
			btnGroup1.add(b2);
			bttnG1.add(b2);
		}
		if(QQSM_master.getFiftyfifty()){
			b3 = new JButton("50-50");
			btnGroup1.add(b3);
			bttnG1.add(b3);
		}
		buttonsGroup.add(bttnG1);
		
		//Ajuda Público
		b1.addMouseListener(new MouseReleased(){
	        @Override public void mouseReleased(MouseEvent arg0) {
	        	publicHelp();
	        }
	    });
		
		//Telefone
		b2.addMouseListener(new MouseReleased(){
	        @Override public void mouseReleased(MouseEvent arg0) {
	        	call();
	        }
	    });
		
		//50-50
		b3.addMouseListener(new MouseReleased(){
	        @Override public void mouseReleased(MouseEvent arg0) {
	        	fiftyfifty();
	        }
	    });
		
		//2º Group
		ButtonGroup btnGroup2 = new ButtonGroup();
		JPanel bttnG2 = new JPanel();
		bttnG1.setVisible(true);
		
		JButton b4 = new JButton("Desistir");
		btnGroup2.add(b4);
		bttnG2.add(b4);
		JButton b5 = new JButton("Confirmar");
		btnGroup2.add(b5);
		bttnG2.add(b5);
		
		//Quando clica para saber qual a resposta a pergunta
		b5.addMouseListener(new MouseReleased(){
	        @Override public void mouseReleased(MouseEvent arg0) {
	        	verifyAnswer(getSelectedButtonAsnwerText());
	        }
	    });
		
		//Quando clica em Desistir!
		b4.addMouseListener(new MouseReleased(){
	        @Override public void mouseReleased(MouseEvent arg0) {
	        	JOptionPane.showMessageDialog(getContentPane(),
	                    "Desistiu! O programa vai encerrar..");
	        	System.exit(0);
	        }
	    });
		
		buttonsGroup.add(bttnG2);
		pane.add(buttonsGroup);
		
		return pane;
	}
	
	private void fiftyfifty() {
		b3.setVisible(false);
		QQSM_master.setFiftyFifty();
		
		int i=0;
		
		for (Enumeration<AbstractButton> buttons = options.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (!button.getText().equals(ask.getAnswer()) && i!=2){
                button.setVisible(false);
            	i++;
            }
            
            if(i==2){
            	break;
            }
        }
	}
	
	private void call(){
		b2.setVisible(false);
		QQSM_master.setCall();
    	JOptionPane.showMessageDialog(getContentPane(),
                "Pode ligar a quem quiser!");
    	
		//Sugestions
		String help = "";
		boolean verdadeira = false, falsa = false;
		for (Enumeration<AbstractButton> buttons = options.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.getText().equals(ask.getAnswer()) && !verdadeira){
            	help += button.getText()+" - "+((int)(20+Math.random()*(70-Integer.parseInt(ask.getLevel())*10)))+"%\n";
            	verdadeira = true;
            }else if(!falsa){
            	help += button.getText()+" - "+((int)(Math.random()*(40-Integer.parseInt(ask.getLevel())*10)))+"%\n";
            	falsa = true;
            }
            if(verdadeira && falsa){
            	break;
            }
        }
		
		JOptionPane.showMessageDialog(getContentPane(),
                help);
		
	}
	
	private void publicHelp(){
		b1.setVisible(false);
		QQSM_master.setPublico();
    	JOptionPane.showMessageDialog(getContentPane(),
                "Espere um bocadinho pelos resultados do público!");
		//Sugestions
		String help = "";
		
		for (Enumeration<AbstractButton> buttons = options.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.getText().equals(ask.getAnswer())){
            	help += button.getText()+" - "+((int)(20+Math.random()*(70-Integer.parseInt(ask.getLevel())*10)))+"%\n";
            }else{
            	help += button.getText()+" - "+((int)(Math.random()*(40-Integer.parseInt(ask.getLevel())*10)))+"%\n";
            }
        }
		
		JOptionPane.showMessageDialog(getContentPane(),
                help);
		
				
	}
	private String getSelectedButtonAsnwerText(){
         for (Enumeration<AbstractButton> buttons = options.getElements(); buttons.hasMoreElements();) {
             AbstractButton button = buttons.nextElement();

             if (button.isSelected()) {
                 return button.getText();
             }
         }

         return null;
    }
	
	private void verifyAnswer(String answer){
		if(ask.getAnswer().equals(answer)){
			JOptionPane.showMessageDialog(getContentPane(),
                    "Resposta correta!");
			this.getContentPane().removeAll();
			this.getContentPane().add(graphicAsk());
			setVisible(true);
			getContentPane().doLayout();
		    update(getGraphics());
		}else{
			JOptionPane.showMessageDialog(getContentPane(),
                    "Resposta errada!\nResposta correta:"+ask.getAnswer());
		}
	}
}
