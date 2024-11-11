package arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
	public static void main(String args[]) {
		List<Integer> result = new ArrayList<>();
		int a1[]={1, 5, 10,10, 20, 40, 80};
		int a2[]={6, 5,5,7, 10,10,20, 80,80, 100,115};
		int i=0;
		int j=0;
		
		while (i < a1.length && j < a2.length) {
			if (a1[i] == a2[j]) {
				addUniqueueElemToResult(a1,result,i);
				i++;
				j++;
			}
			else if (a1[i] < a2[j]) {
				i++;
			}
			else {
				j++;
			}
		}
		
		for (i=0; i < result.size(); i++) {
			System.out.print(" "+result.get(i));
		}
	}
	private static void addUniqueueElemToResult(int[] a, List<Integer> result,int i) {
		if (result.size() > 0) {
			if (result.get(result.size()-1) != a[i]) {
				result.add(a[i]);
			}
		}
		else {
			result.add(a[i]);
		}
	}
}
