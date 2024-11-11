package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to 
 * construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *  "cats and dog",
 *  "cat sand dog"
 * ]
]
 */
public class WordBreadk2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        Set<String> dict = new HashSet<String>();
        
        for (int i=0; i<wordDict.size(); i++){
            dict.add(wordDict.get(i));
        }
        Map<String,List<String>> memo = new HashMap<>();
        results = getWordBreak(s,dict,memo);
        return results;
    }
    
    public static List<String> getWordBreak(String s, Set<String> dict,Map<String,List<String>> memo){
    
        if (memo.containsKey(s)){
            return memo.get(s);
        }
       
        List<String> result = new ArrayList<>();
        
        if (dict.contains(s)){
            result.add(s);
        }
        
         for (int i=1; i<=s.length(); i++){
            String first = s.substring(0,i);
             if (dict.contains(first)){
            	 System.out.println("Hello");
                 List<String> subList = getWordBreak(s.substring(i),dict,memo);
                 for (String second: subList){
                     result.add(first + " "+second);
                  }
             }
            
        }
        memo.put(s,result);
        return result;
    }
    
    public static void main(String args[]){
    	String s="catsanddog";
    	List<String> wordDict = new ArrayList<>();
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	
    	List<String> result = wordBreak(s,wordDict);
    	
    	for(String str: result){
    		System.out.println(" "+str);
    	}
    }
}
