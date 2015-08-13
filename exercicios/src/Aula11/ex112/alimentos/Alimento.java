package Aula11.ex112.alimentos;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

import java.io.Serializable;

public class Alimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double proteinas;
	private double calorias;
	private double peso;
	
	public Alimento(double calorias, double proteinas, double peso){
		if(proteinas<0){
			throw new IllegalArgumentException("Proteinas de alimento inv?lido!");
		}
		this.proteinas = proteinas;
		if(calorias<0){
			throw new IllegalArgumentException("Calorias de alimento inv?lido!");
		}
		this.calorias = calorias;
		if(peso<0){
			throw new IllegalArgumentException("Peso de alimento inv?lido!");
		}
		this.peso = peso;
	}
	
	public double calTotalCalorias(){
		return ((this.peso)*(this.calorias))/100;
	}
	
	public double calTotalProteinas(){
		return ((this.peso)*(this.proteinas))/100;
	}
	
	public double calCalorias(){
		return this.calorias;
	}
	
	public double calProteinas(){
		return this.calorias;
	}
	
	public double getPeso(){
		return this.peso;
	}
	
	@Override public String toString(){
		return "Prote?nas "+proteinas+", calorias "+calorias+", Peso "+peso;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(getClass()!=b.getClass()){
			return false;
		}else{
			return proteinas==((Alimento)b).proteinas && calorias==((Alimento)b).calorias && peso==((Alimento)b).peso;
		}
	}

}
