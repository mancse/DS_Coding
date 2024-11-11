package TwoPointers;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).

   Example:

   Input: S = "ADOBECODEBANC", T = "ABC"
   Output: "BANC"
   Note:

   If there is no such window in S that covers all characters in T, return the empty string "".
   If there is such window, you are guaranteed that there will always be only one unique 
   minimum window in S.
 * @author Manoj.K
 * Idea: Idea is to take two pointer approach like left and right pointer. 
 *       -Initialize left and right pointer from 0. 
 *       -Increment right pointer to right until the sub array between left and right pointer contains all characters
 *        of array T with same frequencies.
 *       -Now start incrementing left pointer to check if smaller window is still containing all characters of array T. 
 *        If yes, then keep on storing the start and end index of smaller window so far. 
 *       -Continue step-2 until the end of the S string. 
 */
public class MinimumWindowSubstring 
{
	public static String minWindow(String s, String t) 
    {
        if (s.length() == 0 || t.length()==0)
        {
            return "";
        }
        
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        
        for (int i=0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            int count = tMap.containsKey(c)? tMap.get(c):0;
            tMap.put(c,count+1);
        }
        
        int requiredLength = tMap.size();
        System.out.println("Required length: "+requiredLength);
        int left = 0;
        int right = 0;
        int ans[] = {-1,0,0};
        
        int currLength = 0;
        while(right < s.length())
        {
            char c= s.charAt(right);
            int count = sMap.containsKey(c)? sMap.get(c):0;
            sMap.put(c,count+1);
            
            if (tMap.containsKey(c) && tMap.get(c) == sMap.get(c))
            {
                currLength++;
            }
            System.out.println("CurrLength:"+currLength);
            //Contract the window if possible by incrementing left pointer.
            
            while(left <= right && currLength == requiredLength)
            {
                c = s.charAt(left);
                if (ans[0] == -1 || ans[0] > right - left + 1)
                {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                //Decrement the current length of window only if left pointer character is part of T and frequency
                //of that character is same as the frequency of S. It means incrementing this left pointer is    
                //will cause the current window not having the desired characters. 
                //Note:This condition means don't decrement currLength always inside this loop. 
                
                if (tMap.containsKey(c) && tMap.get(c) == sMap.get(c))
                {
                    currLength--;
                }
                System.out.println("CurrLength:--"+currLength);
                //Decrement the frequency of the character pointed by left pointer. 
                sMap.put(c,sMap.get(c) -1);
                
                //Move left pointer forward.
                left++;
            }
                
            right++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }

	 public static void main(String args[])
	 {
		 String s = "ADOBECODEBANC";
		 String t = "ABC";
		 
		 String result =minWindow(s,t);
		 System.out.println("Result: "+result);
	 }
}
