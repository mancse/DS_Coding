package SearchingAndSorting;

public class SubArraySumForOnlyPositiveNumbers 
{
    public static void main(String args[])
    {
    	int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
    	subArraySum(arr,23);
    }
    
    private static void subArraySum(int arr[],int sum)
    {
    	int start = 0;
    	int i =1;
    	int currSum = arr[0];
    	int n = arr.length;
    	boolean found = false;
    	
    	/*
    	 * Add array elements to the currSum until it becomes greater than or equal to sum. 
    	 * If it is greater than sum then subtract elements from start element.
    	 */
    	for ( ; i < n ; i++)
    	{
    		/*
    		 * Once currSum is greater than sum, then remove starting element from array and
    		 * increment start index.
    		 */
    		while (currSum > sum && start < i)
    		{
    			currSum = currSum - arr[start];
    			start = start + 1;
    		}
    		
    		/*
    		 * If it is equal to sum then sub-array is found. Else keep on adding array element
    		 * to currSum.
    		 */
    		if (currSum == sum)
    		{
    			found = true;
    			break;
    		}
    		else
    		{
    			currSum = currSum + arr[i];
    		}
    	}
    	
    	if (found)
    		System.out.println("Sub Array found between index: "+start+" , "+(i-1));
    	else 
    		System.out.println("Sub Array not found");
    }
    
}
