package Aula10.ex101;
/**
 * @author Ant???nio Rafael Ferreira
 * nmec 67405
 */
public interface Iterator<T>{
	public boolean hasNext();
	public T next();
	public void remove();
}