package Heap;

public class MaxHeap 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
        int arr[] = {1,14,10,8,7,9,3,2,4,6};
        
        buildMaxHeap(arr);
        
        System.out.println("Max Heap is: ");
        
        for(int i=0; i<arr.length; i++)
        {
        	System.out.print(" "+arr[i]);
        }
        /*
         * After max heap is created using buildMaxHeap method, 
         * -Iterate max heap in reverse order i.e from size-1 backward and swap with zoro'th indexed heap element. 
         * -After swapping, call heapify method for reduced array size on each consecutive iteration.
         */
        sortHeap(arr);
        System.out.println("\nSorted array: ");
        for(int i=0;i<arr.length;i++){
        	System.out.print(" "+arr[i]);
        }
	}
	private static void buildMaxHeap(int arr[])
	{
		int size = arr.length;
	
		for (int i= size/2 -1 ; i >=0; i--)
		{
			maxHeapify(arr,size,i);
		}
	}
	
	private static void sortHeap(int arr[]){
		for (int i=arr.length-1; i>0; i--){
			swap(arr,0,i);
			//Heapify for root element at index 0 and only for reduced size i.e i.
			maxHeapify(arr,i,0);
		}
		System.out.println("\n");
	}
	
	private static void maxHeapify(int arr[], int n, int i)
	{
		int largest = i;
		int l = 2*i +1;
		int r = 2*i +2;
		
		if (l < n && arr[l] > arr[largest])
		{
			largest = l;
		}
		
		if (r < n && arr[r] > arr[largest])
		{
			largest = r;
		}
		
		if (i != largest)
		{
			swap(arr,i,largest);
			maxHeapify(arr,n,largest);
		}
	}
	
	private static void swap(int arr[],int i, int largest)
	{
		int tmp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = tmp;
	}
    private static int extractHeapMax(int arr[])
    {
    	int max = arr[0];
    	int size = arr.length;
    	
    	/*
    	 * In case of delete of the root element, the last indexed node element is copied to the root element
    	 * and then heapify again.
    	 */
    	arr[0] = arr[size-1];
    	size=size-1;
    	
    	maxHeapify(arr,size,0);
    	
    	System.out.println("\nNew Max Heap is: ");
    	
    	for(int i=0; i<size-1; i++)
        {
        	System.out.print(" "+arr[i]);
        }
    	return max;
    }
}
