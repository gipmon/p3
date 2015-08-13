package Aula1;

import java.util.HashMap;
import java.util.Scanner;

public class problema3 {

	public static void main(String[] args){
		int opcao;
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Rectangulo> rectangulos = new HashMap<String, Rectangulo>();
		HashMap<String, Circulo> circulos = new HashMap<String, Circulo>();
		HashMap<String, Quadrado> quadrados = new HashMap<String, Quadrado>();
		
		do{
			menu();
			opcao = sc.nextInt();
			
			double x, y;
			Ponto lt;
			Ponto rb;
			String key;
			
			switch(opcao){
				case 1: 
					System.out.println("--Adicionar Rect�ngulo--");
					
					System.out.println("\\Coordenadas do ponto do lado esquerdo superior:");
					System.out.print("X: ");
					x = sc.nextDouble();
					System.out.print("Y: ");
					y = sc.nextDouble();
					lt = new Ponto(x, y);
					
					System.out.println("\\Coordenadas do ponto do lado direito inferior:");
					System.out.print("X: ");
					x = sc.nextDouble();
					System.out.print("Y: ");
					y = sc.nextDouble();
					rb = new Ponto(x, y);
					
					
					System.out.println("\\Identificador (chave): ");
					key = sc.next();
					
					Rectangulo value = new Rectangulo(lt, rb);
					rectangulos.put(key, value);
					
					System.out.println("\n--�rea: "+value.area());
					System.out.println("--Per�metro: "+value.perimetro()+"\n");
					break;
				case 2:
					System.out.println("--Adicionar Quadrado--");
					
					System.out.println("\\Coordenadas do ponto do lado esquerdo superior:");
					System.out.print("X: ");
					x = sc.nextDouble();
					System.out.print("Y: ");
					y = sc.nextDouble();
					lt = new Ponto(x, y);
					
					System.out.println("\\Coordenadas do ponto do lado direito inferior:");
					System.out.print("X: ");
					x = sc.nextDouble();
					System.out.print("Y: ");
					y = sc.nextDouble();
					rb = new Ponto(x, y);
					
					
					System.out.println("\\Identificador (chave): ");
					key = sc.next();
					
					Quadrado value_q = new Quadrado(lt, rb);
					quadrados.put(key, value_q);
					
					System.out.println("\n--�rea: "+value_q.area());
					System.out.println("--Per�metro: "+value_q.perimetro()+"\n");
					break;
				case 3:
					System.out.println("--Adicionar C�rculo--");
					
					System.out.println("\\Coordenadas do centro:");
					System.out.print("X: ");
					x = sc.nextDouble();
					System.out.print("Y: ");
					y = sc.nextDouble();
					Ponto centro = new Ponto(x, y);
					
					System.out.println("\\Raio: ");
					double raio = sc.nextDouble();
					
					System.out.println("\\Identificador (chave): ");
					key = sc.next();
					
					Circulo value_c = new Circulo(centro, raio);
					circulos.put(key, value_c);
					
					System.out.println("\n--�rea: "+value_c.area());
					System.out.println("--Per�metro: "+value_c.perimetro()+"\n");
					break;
				case 4:
					System.out.println("--Ver caracter�sticas de Rect�ngulo--");
					System.out.println("\\Chave: ");
					key = sc.next();
					
					try{
						Rectangulo value_r = rectangulos.get(key);
						System.out.println("\n--�rea: "+value_r.area());
						System.out.println("--Per�metro: "+value_r.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("N�o existe nenhum rect�ngulo com essa chave!");
					}
					break;
				case 5:
					System.out.println("--Ver caracter�sticas de Quadrado--");
					System.out.println("\\Chave: ");
					key = sc.next();
						
					try{
						Quadrado value_qg = quadrados.get(key);
						
						System.out.println("\n--�rea: "+value_qg.area());
						System.out.println("--Per�metro: "+value_qg.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("N�o existe nenhum quadrado com essa chave!");
					}
					break;
				case 6:
					System.out.println("--Ver caracter�sticas de C�rculo--");
					System.out.println("\\Chave: ");
					key = sc.next();
					
					try{
						Circulo value_cg = circulos.get(key);
						
						System.out.println("\n--�rea: "+value_cg.area());
						System.out.println("--Per�metro: "+value_cg.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("N�o existe nenhum c�rculo com essa chave!");
					}
					break;
				case 7:
					System.out.println("--Ver se interceptam (2 c�rculos)--");
					
					System.out.println("\\C�rculo A (chave):");
					String keyA = sc.next();
					
					System.out.println("\\C�rculo B (chave):");
					String keyB = sc.next();
					
					try{
						Circulo A = circulos.get(keyA);
						Circulo B = circulos.get(keyB);
						if(A.intercept(B)){
							System.out.println("Interceptam-se!");
						}else{
							System.out.println("N�o se interceptam-se!");
						}
					}catch(NullPointerException e){
						System.out.println("N�o existe nenhum c�rculo com essa chave!");
					}
					break;
				case 8:
					System.out.println("--Ver se s�o iguais (2 c�rculos)--");
					
					System.out.println("\\C�rculo A (chave):");
					String keya = sc.next();
					
					System.out.println("\\C�rculo B (chave):");
					String keyb = sc.next();
					
					try{
						Circulo A = circulos.get(keya);
						Circulo B = circulos.get(keyb);
						if(A.equals(B)){
							System.out.println("S�o iguais!");
						}else{
							System.out.println("N�o s�o iguais!");
						}
					}catch(NullPointerException e){
						System.out.println("N�o existe nenhum c�rculo com essa chave!");
					}
					break;
			}
		}while(opcao!=9);
	}
	private static void menu(){
		System.out.println("--Menu--");
		System.out.println("1. Adicionar Rect�ngulo");
		System.out.println("2. Adicionar Quadrado");
		System.out.println("3. Adicionar C�rculo");
		System.out.println("4. Ver caracter�sticas de Rect�ngulo");
		System.out.println("5. Ver caracter�sticas de Quadrado");
		System.out.println("6. Ver caracter�sticas de C�rculo");
		System.out.println("7. Ver se interceptam (2 c�rculos)");
		System.out.println("8. Ver se s�o iguais (2 c�rculos)");
		System.out.println("9. Terminar");
		System.out.print("Op��o: ");
	}
}
