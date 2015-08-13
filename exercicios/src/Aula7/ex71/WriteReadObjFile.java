package Aula7.ex71;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteReadObjFile{
	
	public static Object randObject(int max){
		switch ((int) (Math.random() * (max))){
			case 0:
				return new Data(11,2,2001); 
			case 1:
				return new Pessoa("Maria Costa", 234342124, new Data(12,9,1972)); 
			case 2:
				return new Circulo(1,3, 1); 
			default:
				return null; 
		}
	}
	
	public static void writeObjectArray() throws FileNotFoundException, IOException{ 
		try {
			Object[] array = new Object[10];
		
			for(int i = 0; i < array.length; i++) 
				array[i] = randObject(3);
			
			FileOutputStream file = new FileOutputStream("test.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(array);
			out.flush();
			out.close();
			System.out.println("");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void readFile() throws FileNotFoundException, IOException{ 
		try{
			FileInputStream file = new FileInputStream("test.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			Object b = in.readObject();
			
			if(b instanceof Object[]){
				Object[] list = (Object[])b;
				for(Object row : list){
					System.out.println(row.getClass().getSimpleName()+" -> "+row);
				}
			}else{
				System.out.println(b.getClass().getSimpleName()+" - > "+b);
			}
			
			in.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException{  
		writeObjectArray();
		readFile();
	}
}
