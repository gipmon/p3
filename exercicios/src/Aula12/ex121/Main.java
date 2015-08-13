package Aula12.ex121;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	private static String namespaces[] = {"Aula12.ex121.alimentos.", "Aula12.ex121.geometria.", "Aula12.ex121.pessoa."};
	
	public static void main(String args[]){
		System.out.print("Nomde da Class: ");
		Scanner sc = new Scanner(System.in);
		String in = "Circulo";//sc.next();
		ClassForName(0, in);
		sc.close();
	}
	
	private static void ClassForName(int i, String nameclass){
		try {
			String option;
			Class<?> p = Class.forName(namespaces[i]+nameclass);
			LinkedList<Object> ll = new LinkedList<>();
			Scanner sc = new Scanner(System.in);
			
			do{
				Inspector insp = new Inspector(p);
				System.out.println(insp.getCharacteristic());
				
				System.out.println("-------------------------------");
				
				Object inst = insp.instance();
				
				System.out.print("Quer criar mais instâncias? ");
				option = sc.next();
				
				ll.add(inst);
			}while(option.equalsIgnoreCase("y"));
			
			System.out.println("-------------------------------");
			
			for(Object b : ll.toArray()){
				System.out.println(b);
			}
			sc.close();
		} catch (ClassNotFoundException e) {
			if((i+1)==namespaces.length){
				System.out.println("Class não encontrada! ");
			}else{
				ClassForName(++i, nameclass);
			}
		}
	}
	
}
