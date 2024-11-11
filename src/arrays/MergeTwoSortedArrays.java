package arrays;

public class MergeTwoSortedArrays {
    public static void main(String args[])
    {
    	int a1[] = {3,5,8,18};
    	int a2[] = {2,4,6,7,8,11,13};
    	int res[] = sortArrays(a1,a2);
    	System.out.println("Sorted Array: ");
    	
    	for (int i=0; i<res.length ;i++)
    	{
    		System.out.print(" "+res[i]);
    	}
    }
    
    private static int[] sortArrays(int a1[],int a2[])
    {
    	int res[] = new int[a1.length + a2.length];
    	
    	int i=0,j=0,k=0;
    	
    	while(i< a1.length && j < a2.length)
    	{
    		if (a1[i] <= a2[j])
    		{
    			res[k++] = a1[i++];
    		}
    		else
    		{
    			res[k++] = a2[j++];
    		}
    	}
    	
    	while(i < a1.length)
    	{
    		res[k++] = a1[i++];
    	}
    	while(j < a2.length)
    	{
    		res[k++] = a2[j++];
    	}
    	
    	return res;
    }
}
