package treino.pratico.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Error {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream(new File("error.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Data d = new Data(1, 2, 4);
		oos.writeObject(d);
		oos.flush();
		oos.close();
		// ----------------------------------------------------------------- //
		FileInputStream fis = new FileInputStream(new File("error.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
			Data yeah = (Data) ois.readObject();
			System.out.println(yeah);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ois.close();
	}
}
