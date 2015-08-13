// Rafael Ferreira https://github.com/gipmon/p3

package Aula4.ex43;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.util.Calendar;

public class Data {
	  
	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano){
		if(!dataValida(dia, mes, ano)){
			throw new IllegalArgumentException("A data inserida Ž inv‡lida!");
		}
		this.dia = dia;
	    this.mes = mes;
	    this.ano = ano;
	}
	
	final public static Data currentDate(){
		Calendar rightNow = Calendar.getInstance();
		return new Data(rightNow.get(Calendar.DAY_OF_MONTH), rightNow.get(Calendar.MONTH)+1, rightNow.get(Calendar.YEAR));
	}
	
	private static boolean bisSexto(int a){ // a = ano
		return (a%400==0 || (a%4==0 && a%100!=0));
	}
	  
	private static int nDias(int a, int b){
		switch(b){
	      case 1: return 31;
	      case 2:
	              if(bisSexto(a))
	                return 29;
	              else
	                return 28;
	      case 3: return 31; 
	      case 4: return 30;
	      case 5: return 31;
	      case 6: return 30;
	      case 7: return 31;
	      case 8: return 31;
	      case 9: return 30;
	      case 10: return 31;
	      case 11: return 30;
	      case 12: return 31;
	    }
	    return 0;
	}
	  
	public boolean dataValida(int dia, int mes, int ano){
	    if(ano<1){
	      return false;
	    }else if(mes>12 || mes<1){
	      return false;
	    }else if(dia>nDias(ano, mes) || dia<1){
	      return false;
	    }else 
	      return true;
	}
	  
	public final int getDia(){
	    return dia;
	}
	  
	public final int getMes(){
	    return mes;
	}
	  
	public final int getAno(){
	    return ano;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return dia==((Data)b).dia && mes==((Data)b).mes && ano==((Data)b).ano;
	}
	 
	@Override public String toString() {
		return this.dia+"/"+this.mes+"/"+this.ano;
	}
}