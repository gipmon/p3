// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex83;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private Bitmap bmp;
	
	private File bmp_file;
	private File bmp_flipv;
	private File bmp_fliph;
	private File bmp_red;
	
	private File selected;
	
	private JPanel background;
	private JPanel pictureBox;
	protected JPanel center;
	
	public GUI(){
		//Choosing an file se não fecha!
		
		JFileChooser fileOpen = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.bmp", "bmp");
		fileOpen.addChoosableFileFilter(filter);
		float resp = 123;
		try{
			resp = fileOpen.showDialog(null, "Escolha um ficheiro!");
		}catch(IllegalArgumentException e){
			System.exit(0);
		}
		if(resp == JFileChooser.APPROVE_OPTION){
			bmp_file = fileOpen.getSelectedFile();
			bmp = new Bitmap(bmp_file);
		}else{
			System.exit(0);
		}
		if(bmp_file==null || !bmp_file.exists() || !bmp_file.isFile() || !bmp_file.canRead()){
			System.exit(0);	
		}
		
		//Já temos o ficheiro!
		
		setLocationByPlatform(true);
		setSize(630, 450);
		setTitle("Editor de BMP");

		background = new JPanel();
		background.setLayout(new BorderLayout());

		//MENU
		JPanel menu = new JPanel();
		menu.setBorder(new EmptyBorder(10, 90, 10, 90) );
		menu.setLayout(new GridLayout(1, 5));
		menu.setVisible(true);

		final Button flipV = new Button("Flip Vertical");
		flipV.setVisible(true);
		menu.add(flipV);

		final Button flipH = new Button("Flip Horizontal");
		flipH.setVisible(true);
		menu.add(flipH);

		final Button red = new Button("Redimensionar 1/2");
		red.setVisible(true);
		menu.add(red);
		background.add(menu, java.awt.BorderLayout.NORTH);
		
		//Menu menu_west
		JPanel menu_west = new JPanel();
		menu_west.setBorder(new EmptyBorder(0, 10, 10, 0) );
		menu_west.setLayout(new GridLayout(5, 1));
		menu_west.setVisible(true);
		
		final Button orig_menu_west = new Button("Ver Original");
		orig_menu_west.setEnabled(false);
		orig_menu_west.setVisible(true);
		menu_west.add(orig_menu_west);
		
		final Button flipV_menu_west = new Button("Ver Flip Vertical");
		flipV_menu_west.setEnabled(false);
		flipV_menu_west.setVisible(true);
		menu_west.add(flipV_menu_west);

		final Button flipH_menu_west = new Button("Ver Flip Horizontal");
		flipH_menu_west.setEnabled(false);
		flipH_menu_west.setVisible(true);
		menu_west.add(flipH_menu_west);

		final Button red_menu_west = new Button("Ver Redimensionar 1/2");
		red_menu_west.setEnabled(false);
		red_menu_west.setVisible(true);
		menu_west.add(red_menu_west);
		
		final Button save_menu_west = new Button("Gravar visualizada");
		save_menu_west.setEnabled(false);
		save_menu_west.setVisible(true);
		menu_west.add(save_menu_west);
		
		background.add(menu_west, java.awt.BorderLayout.WEST);
		
		//CENTER
		JPanel pictureBox = new JPanel();
		pictureBox.setVisible(true);
		showImage(bmp_file);
	
		//Listeners Menu
		flipV.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				flipVOriginal();
				setVisibleAll(orig_menu_west, flipV_menu_west);
			}
		});
		flipH.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				flipHOriginal();
				setVisibleAll(orig_menu_west, flipH_menu_west);
			}
		});
		red.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				redOriginal();
				setVisibleAll(orig_menu_west, red_menu_west);
			}
		});
		
		//Listeners West
		orig_menu_west.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				showImage(bmp_file);
				optionsAvailable(bmp_file, save_menu_west);
			}
		});
		flipV_menu_west.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				showImage(bmp_flipv);
				optionsAvailable(bmp_flipv, save_menu_west);
			}
		});
		flipH_menu_west.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				showImage(bmp_fliph);
				optionsAvailable(bmp_fliph, save_menu_west);
			}
		});
		red_menu_west.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				showImage(bmp_red);
				optionsAvailable(bmp_red, save_menu_west);
			}
		});
		save_menu_west.addMouseListener(new MouseReleased(){
			@Override public void mouseReleased(MouseEvent arg0) {
				save(save_menu_west);
			}
		});
		
		super.getContentPane().add(background, "Center");
	}
	
	private void save(Button sv){
		JFileChooser fileOpen = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.bmp", "bmp");
		fileOpen.addChoosableFileFilter(filter);
		fileOpen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		float resp = fileOpen.showDialog(null, "Gravar!");
		if(resp == JFileChooser.APPROVE_OPTION){
			File dest_file = fileOpen.getSelectedFile();
			selected.renameTo(dest_file);
			sv.setEnabled(false);
		}else{
			alert("Digite o nome do ficheiro .bmp e onde pretende gravar!");
			return;
		}
	}
	
	private void optionsAvailable(File selected, Button...array){
		if(selected!=null){
			for(Button bt : array){
				bt.setEnabled(true);
			}
		}
		this.selected = selected;
	}
	
	private void setVisibleAll(Button... array){
		for(Button bt : array){
			bt.setEnabled(true);
		}
	}
	
	private void flipVOriginal(){
		try {
			bmp_flipv = File.createTempFile("flipV", ".bmp");
			bmp.flipVertical(bmp_flipv);
			showImage(bmp_flipv);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void flipHOriginal(){
		try {
			bmp_fliph = File.createTempFile("flipH", ".bmp");
			bmp.flipHorizontal(bmp_fliph);
			showImage(bmp_fliph);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void redOriginal(){
		try {
			bmp_red = File.createTempFile("flipRed", ".bmp");
			bmp.resize025(bmp_red);
			showImage(bmp_red);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void showImage(File file){
		if(pictureBox!=null){
			background.remove(pictureBox);
		}
		pictureBox = new JPanel();
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(file);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setVisible(true);
			pictureBox.add(picLabel);
;			background.add(pictureBox, java.awt.BorderLayout.CENTER);
		} catch (IOException e){
			e.printStackTrace();
		}
		if(super.getContentPane().getComponentCount()==1)
			super.getContentPane().remove(background);
		super.getContentPane().add(background);
	}
	
	protected void alert(String message){
		JOptionPane.showMessageDialog(getContentPane(), message);
	}

	abstract class MouseReleased extends MouseAdapter{
		public abstract void mouseReleased(MouseEvent arg0);
	}

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
            	GUI gui = new GUI();
        		gui.setDefaultCloseOperation(3);
        		gui.setVisible(true);
            }
        });
	}
}
