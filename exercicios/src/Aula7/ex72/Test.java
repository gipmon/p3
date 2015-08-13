// Rafael Ferreira https://github.com/gipmon/p3

package Aula7.ex72;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;

public class Test {
	public static void main(String args[]){
		File f1 = new File("Figura.bmp");
		Bitmap bmp = new Bitmap(f1);
		System.out.println(bmp.equals(bmp));
		//catacteristics of f1
		System.out.println(bmp);
		//copy
		File f2 = new File("Test1.bmp");
		bmp.write(f2);
		//get the raw
		File f3 = new File("Test.raw");
		bmp.getBmpRaw(f3);
		//reisize image
		File f4 = new File("Resized14.bmp");
		bmp.resize025(f4);
		//flip vertical 
		File f5 = new File("FlipImageVertical.bmp");
		bmp.flipVertical(f5);
		//flip horizontal 
		File f6 = new File("FlipImageHorizontal.bmp");
		bmp.flipHorizontal(f6);
	}
}
