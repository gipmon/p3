package treino.pratico.ex3;

public class Filme extends Artigo implements Playable{
	
	private Classificacao classificacao;
	
	public Filme(String titulo, double preco, Classificacao classificacao) {
		super(titulo, preco);
		this.classificacao = classificacao;
	}
	
	public Classificacao geClassificacao(){
		return classificacao;
	}
	
	@Override public String toString(){
		return super.toString() + "\t[Filme] - [Classificação]: " + classificacao+ "\n";
	}

	@Override
	public void play() {
		System.out.println("Exibindo! ");
	}
}
