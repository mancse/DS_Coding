package TwoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter 
{
	  public static void main(String args[])
	  {
		  int len = lengthOfLongestSubstring("pwwkey");
		  System.out.println("Length: "+len);
	  }
	  public static int lengthOfLongestSubstring(String s) {
	        
	        Set<Character> set = new HashSet<Character>();
	        int left =0;
	        int right=0;
	        int maxlen=0;
	        while(right < s.length())
	        {
	            if (!set.contains(s.charAt(right)))
	            {
	                set.add(s.charAt(right));
	                maxlen = Math.max(maxlen,set.size());
	                right++;
	            }
	            else
	            {
	                set.remove(s.charAt(left));
	                left++;
	            }
	            System.out.println("left: "+left+"right: "+right);
	            System.out.println(set);
	        }
	        return maxlen;
	    }
}
