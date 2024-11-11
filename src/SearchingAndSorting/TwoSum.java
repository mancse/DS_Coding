package SearchingAndSorting;

import java.util.HashMap;
import java.util.Map;

public class TwoSum 
{

	public static void main(String args[])
	{
		int target= 9;
		int nums [] = {2, 7, 11, 15};
		
		int res [] = twoSum(nums,target);
		for (int i : res)
		{
			System.out.print(" "+res[i]);
		}
	}
	private static int[] twoSum(int[] nums, int target) {
	    int [] res = new int[2];

	    if (nums == null || nums.length ==0)
	        return res;
	            
	    Map<Integer,Integer> map = new HashMap<> ();
	    
	    for (int i=0 ; i < nums.length ; i++)            
	    {
	        map.put(nums[i],i);
	    }
	    
	    for (int i=0; i< nums.length; i++)
	    {
	        int rest = target - nums[i];
	        
	        if (map.containsKey(rest) && i != map.get(rest))
	        {
	            res[0] = i;
	            res[1] = map.get(rest);
	            break;
	        }
	    }
	    return res;
	}
}


