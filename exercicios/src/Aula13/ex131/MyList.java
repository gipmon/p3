// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex131;

import java.util.Iterator;
import java.io.Serializable;

import java.util.NoSuchElementException;

public class MyList<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private T[] vector;
	private int pos;
	
	@SuppressWarnings("unchecked")
	public MyList(){
		pos = 0;
		vector = (T[])(new Object[2]);
	}
	
	public void add(T elem){
		if(pos >= vector.length){
			@SuppressWarnings("unchecked")
			T[] newVector = (T[])(new Object[vector.length*2]);
			System.arraycopy(vector, 0, newVector, 0, vector.length);
			vector = newVector;
		}
		vector[pos++] = elem;
	}
	
	public boolean remove(T elem){
		if(!exists(elem)){
			return false;
		}
		for(int i=0; i<pos; i++){
			if(elem.equals(vector[i])){
				System.arraycopy(vector, i+1, vector, i, vector.length-i-1);
				pos--;
				return true;
			}
		}
		return false;
	}
	
	public boolean exists(T elem){
		for(T element : vector){
			if(elem.equals(element)){
				return true;
			}
		}
		return false;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		
		int it_pos;
		
		public MyIterator(){
			it_pos = 0;
		}
		
		@Override public boolean hasNext() {
			return (it_pos < vector.length && vector[it_pos] != null);
		}

		@Override public T next() {
			if(it_pos >= vector.length || vector[it_pos] == null){
				throw new NoSuchElementException("Não existem mais objectos!");
			}
			return vector[it_pos++];
		}

		@Override public void remove() {
			MyList.this.remove(vector[it_pos]);
		}
		
	}
}
