// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public interface Policia{
	public static int id = 0;
	public enum Tipo{INEM, Bombeiros, GNR, PSP, PJ};
	public String getTipo();
	public String getID();
	public void setID(String ID);
}
