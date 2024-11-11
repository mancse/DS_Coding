package arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfThreeSortedArrays {
	public static void main(String args[]){
		List<Integer> result = new ArrayList<>();
		int a1[]={1, 5, 10,10, 20, 40, 80};
		int a2[]={6, 7, 20, 80,80, 100,115};
		int a3[]={3, 4, 15, 20, 30, 70,70, 80, 120};
		
		int i=0,j=0,k=0;
		while(i<a1.length && j < a2.length &&  k < a3.length){
			if (a1[i] == a2[j] && a2[j] == a3[k]){
				addUniqueElementInResult(a1, result, i);
				i++;
				j++;
				k++;
			} 
			
			else if (a1[i] <= a2[j] && a1[i] <= a3[k]){
				addUniqueElementInResult(a1, result, i);
				i++;
			}
			else if (a2[j] <= a1[i] && a2[j] <= a3[k]){
				addUniqueElementInResult(a2, result, j);
				j++;
			}
			else if (a3[k] <= a1[i] && a3[k] <= a2[j]){
				addUniqueElementInResult(a3, result, k);
				k++;
			}
		}
		while (i < a1.length && j < a2.length) {
			if (a1[i] == a2 [j]) {
				addUniqueElementInResult(a1, result, i);
				i++;
				j++;
			}
			else if (a1[i] < a2[j]) {
				addUniqueElementInResult(a1, result, i);
				i++;
			}
			else {
				addUniqueElementInResult(a2, result, j);
				j++;
			}
		}
		while (j < a2.length && k < a3.length) {
			if (a2[j] == a3 [k]) {
				addUniqueElementInResult(a2, result, i);
				j++;
				k++;
			}
			else if (a2[j] < a3[k]) {
				addUniqueElementInResult(a2, result, j);
				j++;
			}
			else {
				addUniqueElementInResult(a3, result, k);
				k++;
			}
		}
		while (i < a1.length && k < a3.length) {
			if (a1[i] == a3 [k]) {
				addUniqueElementInResult(a1, result, i);
				i++;
				k++;
			}
			else if (a1[i] < a3[k]) {
				addUniqueElementInResult(a1, result, i);
				i++;
			}
			else {
				addUniqueElementInResult(a3, result, k);
				k++;
			}
		}
		
		while(i < a1.length) {
			addUniqueElementInResult(a1, result, i);
			i++;
		}
		
		while(j < a2.length) {
			addUniqueElementInResult(a2, result, j);
			j++;
		}
		while(k < a3.length) {
			addUniqueElementInResult(a3, result, k);
			k++;
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
