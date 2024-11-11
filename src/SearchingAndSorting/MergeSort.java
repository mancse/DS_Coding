package SearchingAndSorting;

public class MergeSort 
{
	public static void main(String args[])
	{
		int arr[] = {3,4,7,8,12,5,9,21,25};
		
		for (int i=0 ; i<arr.length ; i++)
			System.out.print(" "+arr[i]);
		
		
		mergesort(arr,0,arr.length-1);
		
		System.out.println("\nSorted Array is: ");
		
		for (int i=0 ; i<arr.length ; i++)
			System.out.print(" "+arr[i]);
	}
	
	public static void mergesort(int arr[],int left,int right)
	{
		if (right > left)
		{
			int middle = left + (right - left)/2;
			
			mergesort(arr,left,middle);
			mergesort(arr,middle+1,right);
			
			merge(arr,left,middle,right);
		}
	}
	
	public static void merge(int arr[],int left, int middle,int right)
	{
		/*
		 * Find sizes of 2 subarrays and then initialize 2 temporary subarrays of that sizes.
		 */
		
		int size1 = middle - left + 1;
		
		int size2 = right - middle;
		
		int arr1[]= new int[size1];
		int arr2[]= new int[size2];
		
		/*
		 * Copy elements to these temporary arrays.
		 */
		
		for (int i=0; i<size1 ; i++)
		{
			arr1[i] = arr[left+i];
		}
		
		for (int i=0; i<size2; i++)
		{
			arr2[i] = arr[middle+1+i];
		}
		
		/*
		 * Initial indices of 2 subarrays.
		 */
		int i=0,j=0;
		/*
		 * Intial index of merged subarray
		 */
		int k=left;
		
		/**
		 * Copy the smaller element of the two devided subarray into temperory array.
		 * It ensures that temporary array contains elements ascending sorted order.  
		 */
		while(i < size1 && j < size2)
		{
			if (arr1[i] <= arr2[j])
			{
				arr[k++] = arr1[i++];
			}
			else
			{
				arr[k++] = arr2[j++];
			}
		}
		
		/* Copy remaining elements of arr1[] if any */
        while (i < size1) 
        { 
            arr[k++] = arr1[i++]; 
        }
        
        /* Copy remaining elements of arr2[] if any */
        while (j < size2) 
        { 
            arr[k++] = arr2[j++]; 
        }
        
	}
}
