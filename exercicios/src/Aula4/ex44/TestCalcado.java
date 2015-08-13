// Rafael Ferreira https://github.com/gipmon/p3

package Aula4.ex44;
/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
public class TestCalcado {
	public static void main(String[] args) {
		Bota b1 = new Bota("Miss Fininha", "GoldFactory", 75, "Cano"); 
		Bota b2 = new Bota("Miss Fininha", "GoldFactory", 75, "Cano"); 
		BotaDesporto bd1 = new BotaDesporto("IceMountain", "NewGeneration", 99.5,"MeioCano", "SnowBoard");
		
		Calcado c1 = new Chuteira("X75", "Naique", 69.0, "Borracha", (byte) 6);
		Calcado c2 = new Chuteira("fX300", "GaloDesportivo", 74.9, "Aluminio", (byte) 5); 
		Sapatilha s1 = new Sapatilha ("XGold","Pluma", 49.99, "Ginastica");
		Catalogo prope = new Catalogo("Planta do Pé - Primavera/Verão 2013"); 
		
		System.out.println("----- Insercao -----");
		System.out.print(prope.add(b1)+","); //true
		System.out.print(prope.add(b2)+","); //false
		System.out.print(prope.add(bd1)+","); //true
		System.out.print(prope.add(c1)+","); //true
		System.out.print(prope.add(c2)+","); //true
		System.out.println(prope.add(s1)); // true
     
		System.out.println("----- Listagem de Calcado Desportivo -----"); 
		Calcado calDesp[] = prope.getCalcadoDesportivo();
		System.out.println("Preço Total do Calçado Desportivo -> " + precoCalcado(calDesp));
		printFinalidade(calDesp); 
	}
	private static double precoCalcado(Calcado cal[]){ 
		double sum = 0;
		for(Calcado ca : cal){
			sum += ca.getPreco();
		}
		return sum;
	}
	private static void printFinalidade(Calcado cal[]){ 
		for(Calcado ca : cal){
			System.out.println("\n"+ca);
		}
	}
}