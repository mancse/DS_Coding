package RecursionBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 * @author Manoj Kumar
 *
 */
public class LetterCombinationPhoneNumber 
{
	static List<String> result = new ArrayList<String>();
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        if (digits== null || digits.length() ==0)
            return result;
        StringBuilder sb = new StringBuilder();
        dfs(0,sb,digits);
        return result;
    }
    
    private static void dfs(int index,StringBuilder sb,String digits){
        if (index == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        char ch  = digits.charAt(index);
        String str = map[ch - '0'];
        for (int i=0; i<str.length(); i++){
        	sb.append(str.charAt(i));
            dfs(index+1,sb,digits);
            //Backtrack...
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public static void main(String args[]) {
    	List<String> res = letterCombinations("23");
    	System.out.println(res);
    }
}


