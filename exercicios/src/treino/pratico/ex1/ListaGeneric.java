// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex1;

import java.util.Iterator;

public class ListaGeneric<T>{
	
	private Node<T> top = null;
	private int size = 0;
	
	public class Node<E>{
		E elem;
		Node<E> next;
		
		public Node(E elem){
			this.elem = elem;
			next = null;
		}
	}
	
	public void add(T elem){
		Node<T> novo = new Node<T>(elem);
		if(top!=null){
			novo.next = top;
		}
		top = novo;
		size++;
	}
	
	public boolean exists(T elem){
		Node<T> tmp = top;
		
		while(tmp!=null){
			if(tmp.elem==elem){
				return true;
			}
			tmp = tmp.next;
		}
		
		return false;
	}
	
	public boolean remove(T elem){
		if(top==null || elem==null){
			return false;
		}
		
		Node<T> tmp = top;
		
		while(tmp.next!=null){
			if(tmp.next.elem==elem){
				if(tmp.next.next==null){
					tmp.next = null;
				}else{
					tmp = tmp.next.next;
				}
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		
		return false;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	class MyIterator implements Iterator<T>{
		Node<T> it = top;
		
		@Override public boolean hasNext() {
			return it != null;
		}

		@Override
		public T next() {
			T elem = it.elem;
			it = it.next;
			return elem;
		}

		@Override
		public void remove() {
			ListaGeneric.this.remove(it.elem);
		}
		
	}
	
	public T[] toArray(){
		Node<T> tmp = top;
		@SuppressWarnings("unchecked")
		T[] array = (T[])(new Object[size]);
		int i = 0;
		while(tmp!=null){
			array[i++] = tmp.elem;
			tmp = tmp.next;
		}
		return array;
	}
	
	@Override public String toString(){
		Node<T> tmp = top;
		String out = "";
		while(tmp!=null){
			out += "\n"+tmp.elem;
			tmp = tmp.next;
		}
		return out;
	}
}
