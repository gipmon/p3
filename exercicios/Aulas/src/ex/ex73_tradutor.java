// Rafael Ferreira https://github.com/gipmon/p3

package ex;

import java.util.*;
import static java.lang.System.*;

public class ex73_tradutor {
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String a = new String();
		out.print("Frase para tradução: ");
		a=sc.nextLine();
		out.printf("Frase traduzida: %s", Traducao(a));
	}
	public static String Traducao(String a){
		String b = new String();
		for(int i=0; i<a.length(); i++){
			if(a.charAt(i)=='L')
				b+="U";
			else if(a.charAt(i)=='l')
				b+="u";
			else if(a.charAt(i)!='r' && a.charAt(i)!='R')
				b+=a.charAt(i);
		}
		return b;
		//Esta faz a leitura de todos os caracteres constituintes da String inserida e faz uma comparação de cada caracter
		//consuante as condições apresentadas; !Importante! referir que para comparar char com char podemos fazer da seguinte forma
		// char == 'c' <-
	}
}
