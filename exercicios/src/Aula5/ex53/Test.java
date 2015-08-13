// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Test{
	public static void main(String[] args){
		Veiculo lista[] = {
			new Automovel(1994, "Branco", 4, 1384,
					90, 180, 7.5, "Toyota", "Gasolina",
					"34-AB-76", "Normal"),
			new Bicicleta(2011, "Preto", 2, "Estrada"),
			new BicicletaPolicia(1780, "Azul", 1, "BMX", "PJ", "SFA1KMFNIA"),
			new CarroPolicia(2010, "Branco", 4, 2200,
					170, 250, 8, "Lexus", "Gasoleo",
					"12-GNR-12", "Desportivo", "GNR", "ADFSGGF2"),
			new Moto(1980, "Branco", 2, 800,
					80, 220, 5, "Gasolina",
					"AB-22-22", "Street"),
			new MotoPolicia(2003, "Azul", 2, 900,
					85, 300, 20, "Gasolina",
					"AA-32-PSP", "Desportiva", "PSP", "KJKHFFAAD2")
		};
		
		System.out.println("-----\n"+UtilCompare.findMin(lista));
		System.out.println("-----\n"+UtilCompare.findMax(lista));
		
		UtilCompare.sortArray(lista);
		
		for(Comparable row : lista){
			System.out.println("-----\n"+row);
		}
	} 
}
