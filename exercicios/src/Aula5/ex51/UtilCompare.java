// Rafael Ferreira https://github.com/gipmon/p3

package Aula5.ex51;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
public class UtilCompare {
	
	public static Comparable findMax(Comparable[] array){
            int maxIDX = 0;
            
            for(int i=1; i<array.length; i++ )
                    if(array[i].compareTo(array[maxIDX]) > 0 )
                    	maxIDX = i;
            
            return array[maxIDX];
    }
    
    public static void sortArray(Comparable[] array){
            Comparable temp;
            
            for(int i=0; i<array.length; i++)
            	for(int j=i+1; j<array.length-1; j++)
	            	if (array[i].compareTo(array[j])>0){
	            		temp = array[j];
	                    array[j] = array[i];
	                    array[i] = temp;
	                }
            
    }
}
