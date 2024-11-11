package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
 * You may return the answer in any order.An Anagram is a word or phrase formed by rearranging the 
 * letters of a different word or phrase, typically using all the original letters exactly once.
 * Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * @author Manoj Kumar
 *
 */
public class FindAnagramPositions 
{
	public static List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0)
        {
            return result;
        }
        
        int pMap[] = new int[26];
        int sMap[] = new int[26];
        
        for (int i=0; i<p.length(); i++)
        {
        	pMap[p.charAt(i) - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        
        while(right < s.length())
        {
            sMap[s.charAt(right) - 'a']++;
            
            if ((right - left) + 1 == p.length())
            {
            	if (Arrays.equals(sMap, pMap))
            		result.add(left);
            	
            	sMap[s.charAt(left) - 'a']--;
            	left++;
            }
            right++;
        }
        return result;
    }
	
	public static void main(String args[])
	{
		String s="cbaebabacd";
		String p="abc";
		
		List<Integer> result = findAnagrams(s,p);
		System.out.println("Result: "+result);
	}
}
