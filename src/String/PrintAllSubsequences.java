package String;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences 
{
	public static List<String> result = new ArrayList<>();
    public static void main(String args[])
    {
    	String str = "abcd";
    	printAllSubsequences(str,"");
    	System.out.println(result);
    }
    
    /**
     * Idea: Pick/Not pick of a character for answer set. 
     * @param str
     * @param ans
     */
    private static void printAllSubsequences(String str, String ans)
    {
        if (str.length() == 0)
        {
            result.add(ans);
            return;
        }
        /*
         * Pick 1st character as part of subsequence string. 
         */
    	printAllSubsequences(str.substring(1),ans+str.charAt(0));
    	
    	/*
    	 * Dont pick first character as part of subsequence string.
    	 */
    	printAllSubsequences(str.substring(1), ans);
    }
}

