package arrays;
/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * Idea: Traverse both array backward from right side and copy the bigger value at right most index of bigger array. 
 * @author Manoj.K
 *
 */
public class MergeTwoSortedArrayIntoLargerArray 
{
    public static void main(String args[])
    {
    	int a1[] = {2,4,6,7,8,11,13,0,0,0,0};
    	int a2[] = {3,5,8,18};
    	
    	sortArrays(a1,a2);
    }
    
    private static void sortArrays(int a1[],int a2[])
    {
        int m = a1.length - a2.length;
        int n = a2.length;
        int k = a1.length -1;
        while(m > 0 && n>0)
        {
        	if (a1[m-1] > a2[n-1])
        	{
        		a1[k--] = a1[m-1];
        		m--;
        	}
        	else
        	{
        		a1[k--] = a2[n-1];
        		n--;
        	}
        }
        /**
         * Now copy rest of the elements of a2 array whose numbers might be left out. 
         */
        while(n>0)
        {
        	a1[k--] = a2[n-1];
        }
        
        /**
         * No need to do anything if m > 0 because it points to elements of a1 array only. 
         */
        
        /*
         * Now print array
         */
        for(int i=0; i<a1.length; i++)
        {
        	System.out.print(" "+a1[i]);
        }
    }
}
