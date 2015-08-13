package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Test32{
	public static void main(String[]args){
        Condutor condutor = new Condutor("Rafael Ferreira", 12345, new Data(28, 01, 1994), 123, 'A');
        
        Ligeiro ligeiro = new Ligeiro(2200, 175, 1100, 3);
        Mercadorias mercadorias = new Mercadorias(2400, 80, 1200, 2);
        Motociclo motociclo = new Motociclo(150, 150, 300, 2);
        Passageiros passageiros = new Passageiros(1400, 95, 1190, 4);
        Pesado pesado = new Pesado(3000, 150, 4300, 4);
        Veiculo veiculo = new Veiculo(1998, 90, 1200, 3);
        
        System.out.println(condutor.whoAmI()+" - "+condutor+"\n");
        System.out.println(ligeiro.whoAmI()+" - "+ligeiro+"\n");
        System.out.println(mercadorias.whoAmI()+" - "+mercadorias+"\n");
        System.out.println(motociclo.whoAmI()+" - "+motociclo+"\n");
        System.out.println(passageiros.whoAmI()+" - "+passageiros+"\n");
        System.out.println(pesado.whoAmI()+" - "+pesado+"\n");
        System.out.println(veiculo.whoAmI()+" - "+veiculo);
    }
}
