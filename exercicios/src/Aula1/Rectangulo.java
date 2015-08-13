package Aula1;

public class Rectangulo {
	private Ponto lt;
	private Ponto lb;
	private double left;
	
	private Ponto rt;
	private Ponto rb;
	private double top;
	
	public Rectangulo(Ponto lt, Ponto rb){
		lb = new Ponto(lt.getX(), rb.getY());
		rt = new Ponto(rb.getX(), lt.getY());
		this.lt = lt;
		this.rb = rb;
		this.left = this.lt.distancia(this.lb);
		this.top = this.rt.distancia(this.lt);
	}
	
	public Rectangulo(Ponto lt, Ponto lb, Ponto rt, Ponto rb){
		if(lt.equalsX(lb) && rt.equalsX(rb) && lt.equalsY(rt) && lb.equalsY(rb)){
			this.lt = lt;
			this.lb = lb;
			this.left = this.lt.distancia(this.lb);
			
			this.rt = rt;
			this.rb = rb;
			this.top = this.rt.distancia(this.lt);
		}else{
			throw new IllegalArgumentException("Pontos inv‡lidos!");
		}
	}
	
	public double area(){
		return left*top;
	}
	
	public double perimetro(){
		return left*2+top*2;
	}
	
	public String toString(){
		String out = "Rect‰ngulo\n\n";
		out += "Ponto da direita canto inferior: "+rb.toString()+"\n";
		out += "Ponto da direita canto superior: "+rt.toString()+"\n";
		out += "Comprimento dos lados: "+left+"\n\n";
		out += "Ponto da esquerda canto superior: "+lt.toString()+"\n";
		out += "Ponto da direita canto inferior: "+lb.toString()+"\n";
		out += "Comprimento dos lados (topo): "+top+"\n\n";
		out += "çrea: "+area()+"\n";
		out += "Per’metro: "+perimetro();
		return out;
	}
}
