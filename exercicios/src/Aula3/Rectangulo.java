package Aula3;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.lang.reflect.Array;

public class Rectangulo extends Figura{
	
	private Ponto lt; //left top
	private Ponto lb; //left bottom
	private double largura;
	
	private Ponto rt; //right top
	private Ponto rb; //right bottom
	private double comprimento;
	
	public Rectangulo(Ponto lt, Ponto lb, Ponto rt, Ponto rb){
		super(calCentro(lt, lb, rt, rb));
		
		if(lb.distancia(lt) > lb.distancia(rb)){
			comprimento = lb.distancia(lt);
			largura = lb.distancia(rb);
		}else{
			comprimento = lb.distancia(rb);
			largura = lb.distancia(lt);
		}
		
		this.lt = lt;
		this.lb = lb;
		this.rt = rt;
		this.rb = rb;
	}
	
	public Rectangulo(double lado, double comprimento){
		this(new Ponto(0, lado), new Ponto(0 ,0), new Ponto(comprimento, lado), new Ponto(comprimento, 0));
	}
	
	public Rectangulo(double lado, double comprimento, double lbx, double lby){
		this(new Ponto(lbx, lby+lado), new Ponto(lbx, lby), new Ponto(lbx+comprimento, lby+lado), new Ponto(lbx+comprimento, lby));
	}
	
	public Rectangulo(Rectangulo b){
		//b.getPontos() return {lb, lt, rb, rt}
		this((Ponto)Array.get(b.getPontos(), 1), (Ponto)Array.get(b.getPontos(), 0), (Ponto)Array.get(b.getPontos(), 3), (Ponto)Array.get(b.getPontos(), 2));
	}
	
	private static Ponto calCentro(Ponto lt, Ponto lb, Ponto rt, Ponto rb){
		if(lt.equalsX(lb) && rt.equalsX(rb) && lt.equalsY(rt) && lb.equalsY(rb)){
			return new Ponto(lb.getX()+(lb.distancia(rb)/2), lb.getY()+(lb.distancia(lt)/2));
		}else{
			throw new IllegalArgumentException("Pontos inv‡lidos, n‹o Ž um Rect‰ngulo!");
		}
	}
	
	public double getArea(){
		return comprimento*largura;
	}
	
	public double getPerimetro(){
		return comprimento*2+largura*2;
	}
	
	public double getComprimento(){
		return comprimento;
	}
	
	public double getLargura(){
		return largura;
	}
	
	public Ponto[] getPontos(){
		Ponto[] pontos = {lb, lt, rb, rt};
		return pontos;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		
		Ponto[] ap = getPontos();
		Ponto[] bp = ((Rectangulo)b).getPontos();
		
		for(int i=0; i<ap.length; i++)
			if(!ap[i].equals(bp[i]))
				return false;
		
		return true;
	}
	
	@Override public String toString(){
		String out = "--Rect‰ngulo--\n\n";
		out += "Ponto da esquerda canto inferior: "+lb.toString()+"\n";
		out += "Ponto da esquerda canto superior: "+lt.toString()+"\n";
		out += "Ponto da direita canto inferior: "+rb.toString()+"\n";
		out += "Ponto da direita canto superior: "+rt.toString()+"\n\n";
		out += "Largura: "+largura+"\n";
		out += "Comprimento: "+comprimento+"\n";
		out += "çrea: "+String.format("%.2f", getArea())+"\n";
		out += "Per’metro: "+String.format("%.2f", getPerimetro());
		return out;
	}
}
