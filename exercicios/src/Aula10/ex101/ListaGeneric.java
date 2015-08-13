// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex101;
/**
 * @author Ant???nio Rafael Ferreira
 * nmec 67405
 */
public class ListaGeneric<E>{
	
	class Node{
		Node next;
		E element;
		public Node(E element){
			this.element = element;
		}
	}
	
	private Node top = null;
	private int size = 0;
	
	public void addElem(E element){
		Node novo = new Node(element);
		novo.next = top;
		top = novo;
		size++;
	}
	
	private boolean removeElem(E element){
		Node tmp = top;
		if(top.element.equals(element) && top.next==null){
			top = null;
			size--;
			return true;
		}else if(top.element.equals(element) && top.next!=null){
			top = top.next;
			size--;
			return true;
		}
		while(tmp.next!=null){
			if(tmp.next.element.equals(element)){
				tmp.next = tmp.next.next;
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public int getSize(){
		return size;
	}
	
	public E[] toArray(){
		Node tmp = top;
		@SuppressWarnings("unchecked")
		E[] array = (E[])(new Object[size]);
		int i = 0;
		while(tmp!=null){
			array[i++] = tmp.element;
			tmp = tmp.next;
		}
		return array;
	}
	
	@Override public String toString(){
		Node tmp = top;
		String out = "";
		while(tmp!=null){
			out += "\n"+tmp.element;
			tmp = tmp.next;
		}
		return out;
	}
	
	public Iterator<E> iterator(){
		return new MyIterator<E>();
	}
	
	private class MyIterator<T> implements Iterator<T>{
		Node tmp = top;
		
		@Override public boolean hasNext(){
			return (tmp!=null);
		}

		@Override public T next(){
			@SuppressWarnings("unchecked")
			T p = (T) tmp.element;
			tmp = tmp.next;
			return p;
		}

		@Override public void remove(){
			removeElem(tmp.element);
			tmp = top;
		}
		
	}
}
