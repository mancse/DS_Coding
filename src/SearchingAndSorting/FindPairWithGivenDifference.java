package SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in 
 * the array whose difference is equals to target.
 * 2. If there exists such a pair print it, otherwise print -1.
 * 
 * Sample input:
 * arr 5 2 3 80 5 20
 * target 78
 * 
 * output: 2 80
 * @author Manoj.K
 *
 */
public class FindPairWithGivenDifference {


    public static void findPair(int[]arr,int target) {
        if (arr.length < 2)
            System.out.print(-1);
        
        Arrays.sort(arr);
        int i=0;
        int j=1;
        
        while (j < arr.length){
            int diff = arr[j] - arr[i];
            if (diff == target){
                System.out.print(arr[i]+ " "+arr[j]);
                return;
            }
            
            if (diff < target){
                j++;
            }
            else if (diff > target){
                i++;
            }
        }
        System.out.print(-1);
    }

    public static void main(String[]args) {
        

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        findPair(arr,target);
    }
}
