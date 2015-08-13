package Aula3;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
/*
 * VideoClube -> Aula 2
 */
public class Rating {
	private double total;
	private double medio;
	
	public Rating(double rate){
		if(rate<0 || rate >10){
			throw new IllegalArgumentException("O rate do vídeo deve ser entre 0 e 10 inclusive.");
		}
		this.total = rate;
		this.medio = rate;
	}
	
	public void newRating(double rate){
		if(rate<0 || rate >10){
			throw new IllegalArgumentException("O rate do vídeo deve ser entre 0 e 10 inclusive.");
		}
		this.medio = (this.total+rate)/(this.getN()+1);
		this.total += rate;
	}
	
	public double getTotal(){
		return this.total;
	}
	
	public double getMedio(){
		return this.medio;
	}
	
	private int getN(){
		return (int)(this.total/this.medio);
	}
	
	public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=((Rating)b).getClass()){
			return false;
		}
		return ((Rating)b).getTotal() == total && ((Rating)b).getMedio() == medio;
	}
	
	@Override public String toString(){
		return "Rating total: "+getTotal()+"\nRating médio: "+getMedio();
	}
	
}
