// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex54;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class vCard extends Format implements ReadWriteOP{
	
	public Set<Entry<String, Pessoa>> getFrom(File f){
		if(fileOK(f)){
			read(f);
			return entrySet();
		}else{
			return null;
		}
	}
	
	@Override
	public void read(File f){
		Scanner sc;
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Ficheiro n‹o encontrado!");
		}
		try{
			sc.nextLine();
			while(sc.hasNextLine()){
				String line[] = sc.nextLine().split("#");
				String name = line[1];
				int cc = Integer.parseInt(line[2]);
				String[] ddns = line[3].split("/");
				Data ddn = new Data(Integer.parseInt(ddns[0]), Integer.parseInt(ddns[1]), Integer.parseInt(ddns[2]));
				add(name, ddn, cc);
			}
		}catch(NullPointerException e){
			throw new IllegalArgumentException("Algo de errado se passou!");
		}
	}

	@Override
	public void write(Pessoa[] array, File f) {
		try {
			FileWriter wr = new FileWriter(f);
			wr.write("vCard");
			wr.flush();
			for(Pessoa row : array){
				wr.write("\n#"+row.getName()+"#"+row.getCC()+"#"+row.getDDN());
				wr.flush();
			}
			wr.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Ficheiro inv‡lido!");
		}
	}
}
