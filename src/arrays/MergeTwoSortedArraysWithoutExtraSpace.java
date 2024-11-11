package arrays;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace 
{
	public static void main(String args[])
	{
		int a1[] = {3,5,8,18};
		int a2[] = {2,4,6,7,8,11,13};
		
		mergeSortedArrays(a1,a2);
	}
	
	private static void mergeSortedArrays(int a1[], int a2[])
	{
		int i = 0;
		int j = a2.length -1;
	
		while (i < a1.length && j >=0)
		{
			//Swap if a2[j] > a1[i]
			if (a2[j] > a1[i])
			{
				int tmp = a1[i];
				a1[i] = a2[j];
				a2[j] = tmp;
			}
			
			i++;
			j--;
		}
		
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		for (int k=0; k<a2.length; k++)
		{
			System.out.print(" "+a2[k]);
		}
		
		for (int k=0; k<a1.length; k++)
		{
			System.out.print(" "+a1[k]);
		}
	}
	
}
