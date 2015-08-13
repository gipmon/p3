/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex92;

public class VectorPessoas{
	
		private Pessoa[] vector;
		private int pos;
		
		public VectorPessoas(){
			vector = new Pessoa[2];
			pos = 0;
		}
		
		public void addPessoa(Pessoa pessoa){
			if(pos==vector.length){
				Pessoa[] newVector = new Pessoa[vector.length + 2];
				System.arraycopy(vector, 0, newVector, 0, vector.length);
				vector = newVector;
			}
			vector[pos++] = pessoa;
		}
		
		private void removePessoa(Pessoa pessoa){
			int i=0;
			for(; i<pos; i++){
				if(vector[i].equals(pessoa)){
					break;
				}
			}
			System.arraycopy(vector, i+1, vector, i, vector.length-i);
			pos--;
		}
		
		public int getSize(){
			return vector.length;
		}
		
		public Pessoa[] toArray(){
			return vector;
		}
		
		@Override public String toString(){
			String out = "";
			
			for(int i=0; i<pos; i++){
				out += "\n"+vector[i];
			}
			
			return out;
		}
		
		public Iterator iterator(){
			return new MyIterator();
		}
		
		private class MyIterator implements Iterator{
			private int i=0;
			
			@Override public boolean hasNext(){
				return (i<pos);
			}

			@Override public Pessoa next(){
				return vector[i++];
			}

			@Override public void remove(){
				removePessoa(vector[i]);
				i--;
			}
			
		}
	
}

