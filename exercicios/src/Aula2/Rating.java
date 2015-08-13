// Rafael Ferreira https://github.com/gipmon/p3

package Aula2;

/**
 * @author Ant—nio Ferreira
 * nmec 67405
 */
public class Rating {
	private double total;
	private double medio;
	
	public Rating(double rate){
		if(rate<0 || rate >10){
			throw new IllegalArgumentException("O rate do v’deo deve ser entre 0 e 10 inclusive.");
		}
		this.total = rate;
		this.medio = rate;
	}
	
	public void newRating(double rate){
		if(rate<0 || rate >10){
			throw new IllegalArgumentException("O rate do v’deo deve ser entre 0 e 10 inclusive.");
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
	
	
}
