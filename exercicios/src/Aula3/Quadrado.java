package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.lang.reflect.Array;

public class Quadrado extends Rectangulo{
	
	public Quadrado(Ponto lt, Ponto lb, Ponto rt, Ponto rb){
		super(lt, lb, rt, rb);
		if(getComprimento()!=getLargura()){
			throw new IllegalArgumentException("N‹o Ž um Quadrado!");
		}
	}
	
	public Quadrado(double lado){
		this(new Ponto(0,lado), new Ponto(0,0), new Ponto(lado, lado), new Ponto(lado, 0));
	}
	
	public Quadrado(double lbx, double lby, double lado){
		this(new Ponto(lbx, lby+lado), new Ponto(lbx, lby), new Ponto(lbx+lado, lby+lado), new Ponto(lbx+lado, lby));
	}
	
	public Quadrado(Quadrado b){
		//b.getPontos() return {lb, lt, rb, rt}
		this((Ponto)Array.get(b.getPontos(), 1), (Ponto)Array.get(b.getPontos(), 0), (Ponto)Array.get(b.getPontos(), 3), (Ponto)Array.get(b.getPontos(), 2));
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return super.equals((Rectangulo)b) && getArea()==((Quadrado)b).getArea() && getCentro().equals(((Quadrado)b).getCentro());
	}
	
	@Override public String toString(){
		Ponto[] pontos = getPontos();
		
		String out = "--Quadrado--\n\n";
		out += "Ponto da esquerda canto inferior: "+pontos[0].toString()+"\n";
		out += "Ponto da esquerda canto superior: "+pontos[1].toString()+"\n";
		out += "Ponto da direita canto inferior: "+pontos[2].toString()+"\n";
		out += "Ponto da direita canto superior: "+pontos[3].toString()+"\n";
		out += "Comprimento do lado: "+getComprimento()+"\n\n";
		out += "çrea: "+String.format("%.2f", getArea())+"\n";
		out += "Per’metro: "+String.format("%.2f", getPerimetro());
		return out;
	}
}
