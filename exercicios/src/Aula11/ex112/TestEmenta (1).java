package Aula11.ex112;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

import java.io.File;

import Aula11.ex112.Ementa.DiaSemana;
import Aula11.ex112.alimentos.Carne;
import Aula11.ex112.alimentos.Carne.VariedadeCarne;
import Aula11.ex112.alimentos.Cereal;

public class TestEmenta{
	public static void main(String args[]){
		GerirEmenta ementa = new GerirEmenta();
		
		Carne c1 = new Carne(VariedadeCarne.Frango,  300, 345.3, 22.3);
		Carne c2 = new Carne(VariedadeCarne.Porco,  301, 335.3, 21.3);
		Carne c3 = new Carne(VariedadeCarne.Peru,  341, 335.3, 21.1);
		
		ementa.adicionarIngrediente(c1);
		ementa.adicionarIngrediente(c2);
		ementa.adicionarIngrediente(c3);
		
		Cereal ce1 = new Cereal("Cereal", 120, 333, 12);
		Cereal ce2 = new Cereal("Cereal F", 120, 333, 12);
		Cereal ce3 = new Cereal("Cereal B", 120, 333, 12);
		
		ementa.adicionarIngrediente(ce1);
		ementa.adicionarIngrediente(ce2);
		ementa.adicionarIngrediente(ce3);
		
		System.out.println(ementa.verIngredientes());
		
		ementa.criarPrato("CENA ALTAMENTE", "Normal");
		ementa.addIngredienteToPrato(0, "CENA ALTAMENTE");
		
		ementa.criarPrato("V1", "Vegetariano");
		ementa.addIngredienteToPrato(3, "V1");
		
		System.out.println(ementa.verPratos());
		
		ementa.apagarPrato("V1");
		
		System.out.println(ementa.verPratos());
		
		ementa.addIngredienteToPrato(1, "CENA ALTAMENTE");
		ementa.removeIngredienteOfPrato(0, "CENA ALTAMENTE");
		
		System.out.println(ementa.ingredientsOfPratoToString("CENA ALTAMENTE"));
		
		ementa.criarPrato("V1", "Vegetariano");
		ementa.addIngredienteToPrato(3, "V1");
		
		ementa.criarPrato("V2", "Vegetariano");
		ementa.addIngredienteToPrato(4, "V2");
	
		ementa.criarPrato("V3", "Vegetariano");
		ementa.addIngredienteToPrato(4, "V3");
	
		System.out.println(ementa.verPratos());
		
		ementa.addPratoToEmenta("V1", DiaSemana.Segunda);
		ementa.addPratoToEmenta("V2", DiaSemana.Segunda);
		ementa.addPratoToEmenta("V3", DiaSemana.Segunda);
		
		System.out.println(ementa.printEmenta());
		
		ementa.removePratoFromEmenta("V2", DiaSemana.Segunda);
		
		System.out.println("\n" + ementa.printEmenta());
		
		File f = new File("serial.txt");
		ementa.seralizeObject(f);
		
		ementa = new GerirEmenta();
		ementa.unserializeObject(f);
		
		System.out.println("\n" + ementa.printEmenta());
		
	}
	
	@SuppressWarnings("unused")
	private void printMenu(){
		System.out.println("--Menu--");
		System.out.println("..Ingrediente..");
		System.out.println("1. Adicionar Carne");
		System.out.println("2. Adicionar Peixe");
		System.out.println("3. Adicionar Cereal");
		System.out.println("4. Adicionar Legume");
		System.out.println("..Prato..");
		System.out.println("5. Cria prato");
		System.out.println("6. Apaga prato");
		System.out.println("7. Seleciona prato");
		System.out.println("8. Adiciona ingrediente");
		System.out.println("9. Remove ingrediente");
		System.out.println("..Ementa..");
		System.out.println("10. Adiciona prato");
		System.out.println("11. Remove prato");
		System.out.println("12. Imprime ementa");
	}
}
