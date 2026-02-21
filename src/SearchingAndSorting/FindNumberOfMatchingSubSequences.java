package SearchingAndSorting;
import java.util.*;

/**
 * Leetcode link: https://leetcode.com/problems/number-of-matching-subsequences/description/
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 */
public class NumberOfMatchingSubSequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int match = 0;
        //Store each character and it's index in the following map.
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            List<Integer> list = map.getOrDefault(ch,new ArrayList<Integer>());
            list.add(i);
            map.put(ch,list);
        }
        for (String word : words){
            if (isSubsequence(word,map)){
                match++;
            }
        }
        return match;
    }

    private boolean isSubsequence(String word, Map<Character,List<Integer>> map){

        int prevIndex = -1;
        for (int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            //Return false if particular character not present in the map
            if (!map.containsKey(ch)){
                return false;
            }
            List<Integer> list = map.get(ch);

            //Perform binary search to find next higher index of the current character in the map.
            int nextIndex = getNextIndex(list, prevIndex);

            //If nextIndex is not found until end of the list then return false.
            if (nextIndex == list.size()){
                return false;
            }

            //Store the position of the found valid nextIndex as prevIndex for next character.
            prevIndex = list.get(nextIndex);
        }

        return true;
    }

    private int getNextIndex(List<Integer> list, int prevIndex){
        int left = 0;
        int right = list.size()-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if (list.get(mid) <= prevIndex){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return left;
    }
}
