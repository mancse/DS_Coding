package RecursionBackTracking;

public class FindMaxOfArray 
{
	public static void main(String args[])
	{
		int arr[] = {10,23,2,44,2,13,1};
		
		int max = findMaxOfArray(arr,0);
		System.out.println("Max of array: "+max);
	}
	
	public static int findMaxOfArray(int arr[],int idx)
	{
		if (idx == arr.length - 1)
		{
			return arr[idx];
		}
		
		int submax = findMaxOfArray(arr,idx + 1);
		System.out.println("sub max: "+ submax + " arr[i]: "+arr[idx]);
		return Math.max(arr[idx], submax);
	}
}


