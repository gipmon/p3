// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula9.ex92;

public class ListaPessoas{
		class Node{
			Node next;
			Pessoa pessoa;
			public Node(Pessoa pessoa){
				this.pessoa = pessoa;
			}
		}
		
		Node top = null;
		int size = 0;
		
		public void addPessoa(Pessoa pessoa){
			Node novo = new Node(pessoa);
			novo.next = top;
			top = novo;
			size++;
		}
		
		private boolean removePessoa(Pessoa pessoa){
			Node tmp = top;
			if(top.pessoa.equals(pessoa) && top.next==null){
				top = null;
				size--;
				return true;
			}else if(top.pessoa.equals(pessoa) && top.next!=null){
				top = top.next;
				size--;
				return true;
			}
			while(tmp.next!=null){
				if(tmp.next.pessoa.equals(pessoa)){
					tmp.next = tmp.next.next;
					size--;
					return true;
				}
				tmp = tmp.next;
			}
			return false;
		}
		
		public Pessoa[] toArray(){
			Node tmp = top;
			Pessoa[] array = new Pessoa[size];
			int i = 0;
			while(tmp!=null){
				array[i++] = tmp.pessoa;
				tmp = tmp.next;
			}
			return array;
		}
		
		@Override public String toString(){
			Node tmp = top;
			String out = "";
			while(tmp!=null){
				out += "\n"+tmp.pessoa;
				tmp = tmp.next;
			}
			return out;
		}
		
		public Iterator iterator(){
			return new MyIterator();
		}
		
		private class MyIterator implements Iterator{
			Node tmp = top;
			
			@Override public boolean hasNext(){
				return (tmp.next!=null);
			}

			@Override public Pessoa next(){
				Pessoa p = tmp.pessoa;
				tmp = tmp.next;
				return p;
			}

			@Override public void remove(){
				removePessoa(tmp.pessoa);
				tmp = top;
			}
			
		}
}