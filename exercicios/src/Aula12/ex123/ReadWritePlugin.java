// Rafael Ferreira https://github.com/gipmon/p3

package Aula12.ex123;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.util.Set;
import java.util.Map.Entry;

public interface ReadWritePlugin {
	public Set<Entry<String, Pessoa>> getFrom(File f);
	public void readFile(File f);
	public void writeFile(Pessoa[] array, File f);
}
