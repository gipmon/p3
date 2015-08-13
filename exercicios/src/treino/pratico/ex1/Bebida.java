// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

public abstract class Bebida {
	private String nome;
	private int quantidade;
	private double preco;
	
	public Bebida(String nome, int quantidade, double preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.setPreco(preco);
	}

	public String getNome() {
		return nome;
	}
	
	/*
	 * A bebida pode mudar de nome!
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}else{
			return (((Bebida)b).nome.equals(nome)) &&
					(((Bebida)b).quantidade==quantidade) &&
					(((Bebida)b).preco==preco);
		}
	}
	
	@Override public String toString(){
		return "nome: "+nome+", quantidade: "+quantidade+", preco: "+preco;
	}
}
