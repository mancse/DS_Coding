package SearchingAndSorting;

public class QuickSort
{
	
	public static void main(String args[])
	{
		int arr[] = {3,4,7,8,12,5,9,21,25};
		
		arr = quicksort(arr,0,arr.length-1);
		
		System.out.println("Sorted Array is: ");
		
		for (int i=0 ; i<arr.length ; i++)
			System.out.print(" "+arr[i]);
	}
	private static int [] quicksort(int arr[], int start, int end)
	{
		if (end < start)
			return arr;
		else
		{
			int pviot = partition(arr,start,end,arr[end]);
			arr = quicksort(arr,start,pviot-1);
			arr = quicksort(arr,pviot+1, end);
		}
		return arr;
	 }
	
    private static int partition (int arr[],int start,int end, int pivot)
    {
    	int left = start;
    	int right = end;
    	while(true)
    	{
    		while (left < arr.length -1 && arr[left] < pivot)
    		{
    			left ++;
    		}
    		
    		while (right > 0 && arr[right] > pivot)
    		{
    			right--;
    		}
    		
    		System.out.println("Left: "+left+"Right: "+right+" pivot: "+pivot);
    
    		if (left >= right)
    			break;
    		else
    			arr = swap(arr,left,right);
    	}
    	
    	return left;
    }
    
    private static int [] swap(int arr[], int left, int right)
    {
    	int tmp = arr[left];
    	arr[left] = arr[right];
    	arr[right] = tmp;
    	return arr;
    }
}
