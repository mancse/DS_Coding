package arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
	public static void main(String args[]) {
		List<Integer> result = new ArrayList<>();
		int a1[]={1, 5, 10,10, 20, 40, 80};
		int a2[]={1, 7, 8,10,20, 80,80, 100,115};
		int a3[]={3, 4,8,10, 15, 20, 30, 70,70, 80, 120};
		
		int i=0,j=0,k=0;
		while(i<a1.length && j < a2.length &&  k < a3.length){
			if (a1[i] == a2[j] && a2[j] == a3[k]){
				addUniqueElementInResult(a1, result, i);
				i++;
				j++;
				k++;
			} 
			
			else if (a1[i] <= a2[j] && a1[i] <= a3[k]){
				i++;
			}
			else if (a2[j] <= a1[i] && a2[j] <= a3[k]){
				j++;
			}
			else if (a3[k] <= a1[i] && a3[k] <= a2[j]){
				k++;
			}
		}
		
		for (i=0; i < result.size(); i++) {
			System.out.print(" "+result.get(i));
		}
	}
	private static void addUniqueElementInResult(int[] a, List<Integer> result, int i) {
		if (result.size() > 0){
		    if (a[i] != result.get(result.size()-1))
		        result.add(a[i]);
		}
		else{
		    result.add(a[i]);
		}
	}
}
