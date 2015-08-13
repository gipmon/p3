// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex53;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class UtilCompare{
	public static void sortArray(Comparable array[]){
		Comparable temp;
		
		for(int i=0; i<array.length-1; i++)
			for(int j=i+1; j<array.length; j++)
				if(array[i].compareTo(array[j])>0){
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
		
	}
	
	public static Comparable findMin(Comparable array[]){
		int min = 0;
		
		for(int i=1; i<array.length; i++)
			if(array[i].compareTo(array[min])<0){
				min = i;
			}
		
		return array[min];
	}
	
	public static Comparable findMax(Comparable array[]){
		int max = 0;
		
		for(int i=1; i<array.length; i++)
			if(array[i].compareTo(array[max])>0){
				max = i;
			}
		
		return array[max];
	}
}
