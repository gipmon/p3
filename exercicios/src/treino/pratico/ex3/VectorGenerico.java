// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.ex3;

import java.util.Iterator;

public class VectorGenerico<T> implements Iterable<T>{
	
	private T[] array;
	private int i;
	
	@SuppressWarnings("unchecked")
	public VectorGenerico(){
		array = (T[])(new Object[5]);
		i = 0;
	}
	
	public boolean add(T a) {
		if(i >= array.length){
			@SuppressWarnings("unchecked")
			T[] newarray = (T[])(new Object[array.length*2]);
			System.arraycopy(array, 0, newarray, 0, array.length);
			array = newarray;
		}
		array[i++] = a;
		return true;
	}
	
	public Iterator<T> iterator(int i, int j) {
		return new MyIterator(i, j);
	}
	
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	public int size() {
		return i;
	}

	public boolean isEmpty() {
		return i==0;
	}

	public boolean contains(Object o) {
		for(T e : this){
			if(o.equals(e)){
				return true;
			}
		}
		return false;
	}

	public T[] toArray() {
		return array;
	}
	
	public boolean delete(Object o) {
		if(!contains(o)){
			return false;
		}else{
			for(int pos=0; pos<i; pos++){
				if(o.equals(array[pos])){
					System.arraycopy(array, i+1, array, i, array.length-i-1);
					i--;
					break;
				}
			}
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		array = (T[])(new Object[5]);
		i = 0;
	}
	
	private class MyIterator implements Iterator<T>{
		@SuppressWarnings("unused")
		private int init;
		private int fim;
		private int pos;
		
		public MyIterator(){
			init = pos = 0;
			fim = array.length;
		}
		
		public MyIterator(int init, int fim){
			if(init > fim){
				throw new IllegalArgumentException("init > fim");
			}
			this.init = pos = init;
			this.fim = fim;
		}
		
		@Override
		public boolean hasNext() {
			return (pos < fim && pos < array.length);
		}

		@Override
		public T next() {
			if(hasNext()){
				return array[pos++];
			}else{
				throw new IllegalArgumentException("Doesn't exists next!");
			}
		}

		@Override
		public void remove() {
			delete(array[pos-1]);
		}
		
	}
}
