package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Test31{
	public static void main(String[] args) {
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974)); 
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976));
		
		bls.setBolsa(745);
		
		System.out.println(est.whoAmI() + " : " + est.getName()); System.out.println(est);
		System.out.println(bls.whoAmI() + " : " + bls.getName() + ",NMec:"+bls.getEstNum()+",Bolsa:"+ bls.getBolsa());
		System.out.println(bls.whoAmI() + " : " + bls.getName());
		System.out.println(bls); 
	}
}