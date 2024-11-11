package SearchingAndSorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortArraysBySetBits {
	static class BitComparator implements Comparator<Integer>{
    	@Override
        public int compare(Integer i1, Integer i2){
            int b1 = Integer.bitCount(i1);
            int b2 = Integer.bitCount(i2);
            
            if (b1 != b2){
                return b1-b2;
            }
            else{
                return i1-i2;
            }
        }
    }
    
    public static int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<arr.length; i++){
        	list.add(arr[i]);
        }
        Collections.sort(list, new BitComparator());
        
        for (int i=0; i<list.size(); i++){
        	arr[i] = list.get(i);
        }
        return arr;
    }
}
