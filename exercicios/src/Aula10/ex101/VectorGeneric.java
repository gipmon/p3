// Rafael Ferreira https://github.com/gipmon/p3

package Aula10.ex101;

import java.util.NoSuchElementException;

/**
 * @author Ant???nio Rafael Ferreira
 * nmec 67405
 */
public class VectorGeneric<E>{
	
	private E[] vector;
	private int pos;
	
	@SuppressWarnings("unchecked")
	public VectorGeneric(){
		vector = (E[])(new Object[2]);
		pos = 0;
	}
	
	public void addElem(E element){
		if(pos==vector.length){
			@SuppressWarnings("unchecked")
			E[] newVector = (E[])(new Object[vector.length + 2]);
			System.arraycopy(vector, 0, newVector, 0, vector.length);
			vector = newVector;
		}
		vector[pos++] = element;
	}
	
	private void removeElem(E element){
		int i=0;
		for(; i<pos; i++){
			if(vector[i].equals(element)){
				break;
			}
		}
		System.arraycopy(vector, i+1, vector, i, vector.length-i);
		pos--;
	}
	
	public int getSize(){
		return vector.length;
	}
	
	public E[] toArray(){
		return vector;
	}
	
	@Override public String toString(){
		String out = "";
		
		for(int i=0; i<pos; i++){
			out += "\n"+vector[i];
		}
		
		return out;
	}
	
	public Iterator<E> iterator(){
		return new MyIterator<E>();
	}
	
	private class MyIterator<T> implements Iterator<T>{
		private int i=0;
		
		@Override public boolean hasNext(){
			return (i < vector.length && vector[i] != null);
		}

		@SuppressWarnings("unchecked") 
		@Override public T next(){
			if(i >= vector.length || vector[i] == null){
				throw new NoSuchElementException("Não existem mais objectos!");
			}
			return (T) vector[i++];
		}

		@Override public void remove(){
			removeElem(vector[i]);
			i--;
		}
		
	}

}

