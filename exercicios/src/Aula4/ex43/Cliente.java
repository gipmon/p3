package Aula4.ex43;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class Cliente extends Pessoa{

	private static int nclientes = 0;
	private int nsocio;
	
	public Cliente(String name, Data ddn, int cc){
		super(name, cc, ddn);
		this.nsocio = ++nclientes;
	}
	
	public final int getNsocio(){
		return nsocio;
	}

	public final static int getNClientes(){
		return nclientes;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && nsocio==((Cliente)b).nsocio;
	}
	
	@Override public String toString(){
		return super.toString()+"\nN¼ de s—cio: "+nsocio;
	}
}

