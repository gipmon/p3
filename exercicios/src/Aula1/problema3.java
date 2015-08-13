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
					System.out.println("--Adicionar Rectângulo--");
					
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
					
					System.out.println("\n--Área: "+value.area());
					System.out.println("--Perímetro: "+value.perimetro()+"\n");
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
					
					System.out.println("\n--Área: "+value_q.area());
					System.out.println("--Perímetro: "+value_q.perimetro()+"\n");
					break;
				case 3:
					System.out.println("--Adicionar Círculo--");
					
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
					
					System.out.println("\n--Área: "+value_c.area());
					System.out.println("--Perímetro: "+value_c.perimetro()+"\n");
					break;
				case 4:
					System.out.println("--Ver características de Rectângulo--");
					System.out.println("\\Chave: ");
					key = sc.next();
					
					try{
						Rectangulo value_r = rectangulos.get(key);
						System.out.println("\n--Área: "+value_r.area());
						System.out.println("--Perímetro: "+value_r.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("Não existe nenhum rectângulo com essa chave!");
					}
					break;
				case 5:
					System.out.println("--Ver características de Quadrado--");
					System.out.println("\\Chave: ");
					key = sc.next();
						
					try{
						Quadrado value_qg = quadrados.get(key);
						
						System.out.println("\n--Área: "+value_qg.area());
						System.out.println("--Perímetro: "+value_qg.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("Não existe nenhum quadrado com essa chave!");
					}
					break;
				case 6:
					System.out.println("--Ver características de Círculo--");
					System.out.println("\\Chave: ");
					key = sc.next();
					
					try{
						Circulo value_cg = circulos.get(key);
						
						System.out.println("\n--Área: "+value_cg.area());
						System.out.println("--Perímetro: "+value_cg.perimetro()+"\n");
					}catch(NullPointerException e){
						System.out.println("Não existe nenhum círculo com essa chave!");
					}
					break;
				case 7:
					System.out.println("--Ver se interceptam (2 círculos)--");
					
					System.out.println("\\Círculo A (chave):");
					String keyA = sc.next();
					
					System.out.println("\\Círculo B (chave):");
					String keyB = sc.next();
					
					try{
						Circulo A = circulos.get(keyA);
						Circulo B = circulos.get(keyB);
						if(A.intercept(B)){
							System.out.println("Interceptam-se!");
						}else{
							System.out.println("Não se interceptam-se!");
						}
					}catch(NullPointerException e){
						System.out.println("Não existe nenhum círculo com essa chave!");
					}
					break;
				case 8:
					System.out.println("--Ver se são iguais (2 círculos)--");
					
					System.out.println("\\Círculo A (chave):");
					String keya = sc.next();
					
					System.out.println("\\Círculo B (chave):");
					String keyb = sc.next();
					
					try{
						Circulo A = circulos.get(keya);
						Circulo B = circulos.get(keyb);
						if(A.equals(B)){
							System.out.println("São iguais!");
						}else{
							System.out.println("Não são iguais!");
						}
					}catch(NullPointerException e){
						System.out.println("Não existe nenhum círculo com essa chave!");
					}
					break;
			}
		}while(opcao!=9);
	}
	private static void menu(){
		System.out.println("--Menu--");
		System.out.println("1. Adicionar Rectângulo");
		System.out.println("2. Adicionar Quadrado");
		System.out.println("3. Adicionar Círculo");
		System.out.println("4. Ver características de Rectângulo");
		System.out.println("5. Ver características de Quadrado");
		System.out.println("6. Ver características de Círculo");
		System.out.println("7. Ver se interceptam (2 círculos)");
		System.out.println("8. Ver se são iguais (2 círculos)");
		System.out.println("9. Terminar");
		System.out.print("Opção: ");
	}
}
