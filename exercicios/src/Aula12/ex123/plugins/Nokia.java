// Rafael Ferreira https://github.com/gipmon/p3

package Aula12.ex123.plugins;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import Aula12.ex123.Data;
import Aula12.ex123.Pessoa;
import Aula12.ex123.PluginManager;
import Aula12.ex123.ReadWritePlugin;

public class Nokia extends PluginManager implements ReadWritePlugin{
	
	public Set<Entry<String, Pessoa>> getFrom(File f){
		if(fileOK(f)){
			readFile(f);
			return entrySet();
		}else{
			return null;
		}
	}
	
	@Override
	public void readFile(File f){
		Scanner sc;
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Ficheiro n?o encontrado!");
		}
		try{
			while(sc.hasNextLine()){
				sc.nextLine();
				String name = sc.nextLine();
				int cc = Integer.parseInt(sc.nextLine());
				String[] ddns = sc.nextLine().split("/");
				Data ddn = new Data(Integer.parseInt(ddns[0]), Integer.parseInt(ddns[1]), Integer.parseInt(ddns[2]));
				add(name, ddn, cc);
			}
		}catch(NullPointerException e){
			sc.close();
			throw new IllegalArgumentException("Algo de errado se passou!");
		}
		sc.close();
	}

	@Override
	public void writeFile(Pessoa[] array, File f) {
		try {
			FileWriter wr = new FileWriter(f);
			wr.write("Nokia");
			wr.flush();
			for(int i=0; i<array.length-1; i++){
				wr.write("\n"+array[i].getName()+"\n"+array[i].getCC()+"\n"+array[i].getDDN()+"\n");
				wr.flush();
			}
			wr.write("\n"+array[array.length-1].getName()+"\n"+array[array.length-1].getCC()+"\n"+array[array.length-1].getDDN());
			wr.flush();
			wr.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Ficheiro inv?lido!");
		}
	}
}
