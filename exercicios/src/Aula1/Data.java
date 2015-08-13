package Aula1;

public class Data {
	  private int dia;
	  private int mes;
	  private int ano;

	  public Data(int dia, int mes, int ano){
		if(!dataValida(dia, mes, ano)){
			throw new IllegalArgumentException("A data inserida � inv�lida!");
		}
		this.dia = dia;
	    this.mes = mes;
	    this.ano = ano;
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
	  /*
	  public void setDia(int dia){
		this.dia=dia;
	  }
	  public void setMes(int mes){
	    this.mes=mes;
	  }
	  public void setAno(int ano){
	    this.ano=ano;
	  }
	  */
	  public int getDia(){
	    return dia;
	  }
	  public int getMes(){
	    return mes;
	  }
	  public int getAno(){
	    return ano;
	  }
	  
	  public String toString() {
		  return this.dia+"-"+this.mes+"-"+this.ano;
	  }
	}


