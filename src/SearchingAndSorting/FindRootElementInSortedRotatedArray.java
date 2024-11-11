package SearchingAndSorting;

/**
 Idea: Root element is the element in the array which is greater than it's left and right element in the array. 
 So, use binary search technique to check following conditions:
 1. Check if mid element is greater than it's left and right position of element. If yes then return mid as answer.
 2. Else if mid element is less than the end of the element of the array. If yes, then root element would be at left part of mid.
 3. Else if mid element is greater than the first element of the array. It means root element is at right part of the array. 
 * @author Manoj.K
 *
 */
public class FindRootElementInSortedRotatedArray 
{
	public static void main(String args[])
	{
		int arr[]={7,8,9,10,1,2,3,5,6};
		int start = 0;
		int end = arr.length -1;
		int pos = (end -start)/2;
		int idx = findRootElementIndexOfSortedRotatedArray(arr,start,end,pos);
		
		if (idx > -1)
			System.out.println("Root Element "+arr[idx]+" found at idx: "+idx);
	}
	
	private static int findRootElementIndexOfSortedRotatedArray(int arr[],int start,int end,int pos)
	{
		int retVal = -1;
		if (arr[pos] > arr[pos +1] && arr[pos] > arr[pos -1])
		{
			retVal = pos;
		}
		else if (arr[pos] < arr[arr.length -1])
		{
			end = pos -1;
			pos = (end - start)/2;
			retVal = findRootElementIndexOfSortedRotatedArray(arr,start,end,pos);
		}
		else if (arr[pos] > arr[0])
		{
			start = pos + 1;
			pos = (end - start)/2;
			retVal = findRootElementIndexOfSortedRotatedArray(arr,start,end,pos);
		}
		return retVal;
	}
	
}
