package TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of distinct integers. The task is to count all the triplets such that sum of two elements 
 * equals the third element.
 * @author Manoj.K
 *
 */
public class CountTriplets {
	
  public static int countTriplets(int[] arr) {
	  int count=0;
	  Arrays.sort(arr);
	  
	  for (int i=arr.length-1; i>=2; i--) {
		  int right = i -1; 
		  int left = 0;
		  while (left < right) {
			  int sum = arr[left] + arr[right];
			  if (sum == arr[i]) {
				  count++;
				  left++;
				  right--;
			  }
			  else if (sum < arr[i]) {
				  left++;
			  }
			  else {
				  right--;
			  }
		  }
	  }
	  return count;
  }
  public static void main(String[]args) {
    //input work
    int arr[] = {1,3,4,5,7,8,9};

    System.out.println(countTriplets(arr));
  }
}
