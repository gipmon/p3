package treino.aitp3;

public class Main {
	HashMap<String, Double> s = new Map<>();
}

class Cofre<T> {
	private T elem = null;
	
   	public Cofre(T obj){ 
   		elem = obj; 
   	}
   	public void guarda(T obj){ 
   		elem = obj; 
   	}
   	public T consulta(){ 
   		return elem; 
   	}
}
