package DP;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * @author Manoj.K
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {
public static boolean wordBreak(String s, List<String> wordDict) {
    
    Set<String> dict = new HashSet<String>();
    
    for (int i=0; i<wordDict.size(); i++){
        dict.add(wordDict.get(i));
    }
    
    int dp[] = new int[s.length()];
    for (int i=0; i<dp.length; i++){
        for (int j=0; j<=i; j++){
            String word = s.substring(j,i+1);
            if (dict.contains(word)){
                if (j>0)
                 dp[i] +=dp[j-1];
                else
                 dp[i] +=1;
            }
        }
    }
   
    return dp[dp.length-1]!=0;
}
public static void main(String args[]){
	List<String> wordDict = new ArrayList<>();
	wordDict.add("Hot");
	wordDict.add("Summer");
	wordDict.add("Day");
	
	boolean found = wordBreak("HotSummer",wordDict);
	System.out.println("Found: "+found);
	
	boolean notfound = wordBreak("HotDa",wordDict);
	System.out.println("Found:"+notfound);
    }
}
