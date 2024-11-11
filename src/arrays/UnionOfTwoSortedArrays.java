package arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class UnionOfTwoSortedArrays {

    /*You have to complete union function and return an Arraylist which contains union elements of the two arrays*/
    public static ArrayList<Integer> union(int[] a,int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < a.length && j< b.length){
            if (a[i] == b[j]){
                addUniqueElementInResult(a, result, i);
                i++;
                j++;
            }
            else if (a[i] < b[j]){
                addUniqueElementInResult(a, result, i);
                i++;
            }
            else{
                addUniqueElementInResult(b, result, j);
                j++;
            }
            
        }
        
        while(i < a.length){
             addUniqueElementInResult(a, result, i);
            i++;
        }
        
        while(j < b.length){
            addUniqueElementInResult(b, result, j);
            j++;
        }
        return result;
    }

	private static void addUniqueElementInResult(int[] a, ArrayList<Integer> result, int i) {
		if (result.size() > 0){
		    if (a[i] != result.get(result.size()-1))
		        result.add(a[i]);
		}
		else{
		    result.add(a[i]);
		}
	}

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]a = new int[n];
        for(int i=0; i < n;i++) {
            a[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[]b = new int[m];
        for(int i=0;i < m;i++) {
            b[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = union(a,b);

        //print answer list
        for(int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}