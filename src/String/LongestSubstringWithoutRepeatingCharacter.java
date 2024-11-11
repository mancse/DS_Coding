package String;

import java.util.HashSet;
import java.util.Set;
/**
 * Idea: Start two pointer left and right both starting from zero'th index of string and take one set of character.
 * if character at right index is not in the set then add the character in the set and keep on incrementiong right
 * pointer and also keep on storing lengh of distinct characters so far in set. 
 * 
 * If any character is repeated i.e if it is already in the set... then don't increment right pointer till the time 
 * when all characters are removed from set one by one by left pointer. 
 * 
 * And then again do the same for right pointer until string length is reached. So, stored max length through out this
 * will be answer.
 * @author Manoj.K
 *
 */
public class LongestSubstringWithoutRepeatingCharacter 
{
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
	
	
	public static void main(String args[]){
		String str = "abcddfghijkl";
		System.out.println(lengthOfLongestSubstring(str));
	}
}
