package Aula1;

public class Quadrado {

	private Ponto lt;
	private Ponto lb;
	private Ponto rt;
	private Ponto rb;
	private double lado;
	
	public Quadrado(Ponto lt, Ponto rb){
		this.lt = lt;
		lb = new Ponto(lt.getX(), rb.getY());
		this.rb = rb;
		rt = new Ponto(rb.getX(), lt.getY());
		this.lado = this.lt.distancia(this.lb);
	}
	
	public Quadrado(Ponto lt, Ponto lb, Ponto rt, Ponto rb){
		if(lt.equalsX(lb) && rt.equalsX(rb) && lt.equalsY(rt) && lb.equalsY(rb)){
			this.lt = lt;
			this.lb = lb;
			this.rt = rt;
			this.rb = rb;
			this.lado = this.lt.distancia(this.lb);
		}
	}
	
	public double area(){
		return this.lado*this.lado;
	}
	
	public double perimetro(){
		return this.lado*4;
	}
	
	public double lado(){
		return this.lado;
	}
	
	public String toString(){
		String out = "Quadrado \n\n";
		out += "Ponto da direita canto inferior: "+rb.toString()+"\n";
		out += "Ponto da direita canto superior: "+rt.toString()+"\n";
		out += "Comprimento dos lados: "+lado+"\n\n";
		out += "Ponto da esquerda canto superior: "+lt.toString()+"\n";
		out += "Ponto da direita canto inferior: "+lb.toString()+"\n";
		out += "çrea: "+area()+"\n";
		out += "Per’metro: "+perimetro();
		return out;
	}
}
