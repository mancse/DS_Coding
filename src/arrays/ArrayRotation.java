package arrays;

public class ArrayRotation 
{
	public static void main(String args[])
	{
		int arr []={1,2,3,4,5,6,7,8};
		int arr1 []={1,2,3,4,5,6,7,8};
		printArray(arr);
		int lRrotatedArray[] = rotateLeft(arr,2);
		System.out.println("Left rotated");
		printArray(lRrotatedArray);
		
		int rRotatedArray[] = rotateRight(arr1,2);
		System.out.println("Right rotated");
		printArray(rRotatedArray);
		
		String str = ".1";
		String[] arr2 = str.split("\\.");
		
		System.out.print(" "+arr2[0]+" "+arr2[1]);
	}

	
	/**
	 * 
	 * @param arr : original array
	 * @param d: given number by which the number of times array to be rotated in left direction. 
	 * @return: Result array
	 * 
	 * i.) reverse array from index 0 to index equal to given number d.
	 * ii.) reverse array from given index d to n-1. 
	 * iii.) reverse complete array from index 0 to n-1. 
	 */
	private static int [] rotateLeft(int arr[],int d)
	{
		 if (arr.length == 0)
	            return arr;
	        
	      if (d>arr.length){
	          d = d%arr.length;
	      }
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,arr.length -1);
		reverseArray(arr,0,arr.length -1);
		return arr;
	}
	
	/**
	 * 
	 * @param arr : original array
	 * @param d: given number by which the number of times array to be rotated in right direction. 
	 * @return: Result array
	 * 
	 * i.) reverse array from index 0 to n-1-d .
	 * ii.) reverse array from n-d to n-1. 
	 * iii.) reverse complete array from index 0 to n-1. 
	 */
	 
	private static int[] rotateRight(int arr[],int d)
	{
		if (arr.length == 0)
            return arr;
        
        if (d>arr.length){
          d = d%arr.length;
        }
		reverseArray(arr,0,arr.length-d-1);
		reverseArray(arr,arr.length-d, arr.length -1);		
		reverseArray(arr,0,arr.length-1);
		return arr;
	}
	private static void reverseArray(int arr[],int start,int end)
	{
		int tmp;
		while (start < end)
		{
			tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}
	private static void printArray(int arr[])
	{
		System.out.print(" Array is: ");
		
		for (int i=0; i< arr.length; i++)
		{
			System.out.print(" "+arr[i]);
		}
		System.out.println();
	}
}
