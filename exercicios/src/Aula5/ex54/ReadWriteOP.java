package Aula5.ex54;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.util.Set;
import java.util.Map.Entry;

public interface ReadWriteOP {
	public Set<Entry<String, Pessoa>> getFrom(File f);
	public void read(File f);
	public void write(Pessoa[] array, File f);
}
