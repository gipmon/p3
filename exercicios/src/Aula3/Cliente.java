package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
/*
 * VideoClube -> Aula 2
 */
public class Cliente extends Pessoa{

	private static int nclientes = 0;
	private int nsocio;
	
	public Cliente(String name, Data ddn, int cc){
		super(name, cc, ddn);
		this.nsocio = nclientes++;
	}
	
	public int getNsocio(){
		return nsocio;
	}

	public static int getNClientes(){
		return nclientes;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Pessoa)b) && nsocio==((Cliente)b).getNsocio();
	}
	
	@Override public String toString(){
		return super.toString()+"\nN¼ de s—cio: "+nsocio;
	}
}
