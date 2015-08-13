package Aula1;

import java.util.Scanner;

public class problema1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println("Total de caracteres numéricos (0..9): "+num(str));
		System.out.println("Só minúsculas: "+onlyLower(str));
		System.out.println("Só maiúsculas: "+onlyUpper(str));
		System.out.println("Total de palavras lidas: "+countWords(str)+"\n"+str);
		System.out.println("Imprimir uma nova String na qual todos os caracteres foram trocados 2 a 2: "+change2(str));
	}
	private static String change2(String str){
		if(str.length()==2){
			return Character.toString(str.charAt(1))+Character.toString(str.charAt(0));
		}else if(str.length()==1){
			return str;
		}else if(str.length()==0){
			return "";
		}else{
			return Character.toString(str.charAt(1))+Character.toString(str.charAt(0))+change2(str.substring(2));
		}
	}
	private static int countWords(String str){
		String[] arr = str.split(" ");
		return (str.length()==0)?0:arr.length;
	}
	private static boolean onlyLower(String str){
		boolean val = true;
		for(int i=0; i<str.length() && val; i++){
			if(Character.isUpperCase(str.charAt(i))){
				val=false;
			}
		}
		return val;
	}
	private static boolean onlyUpper(String str){
		boolean val = true;
		for(int i=0; i<str.length() && val; i++){
			if(Character.isLowerCase(str.charAt(i))){
				val=false;
			}
		}
		return val;
	}
	private static int num(String str){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(Character.isDigit(str.charAt(i))){
				count++;
			}
		}
		return count;
	}
}
