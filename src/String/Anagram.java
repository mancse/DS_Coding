package String;

import java.util.HashMap;
import java.util.Map;

public class Anagram 
{
    public static void main(String args[])
    {
    	String str1 = "aacc";
    	String str2 = "ccac";
    	System.out.println("Anagram :"+isAnagram(str1,str2));
    }
    
    private static boolean isAnagram(String str1, String str2)
    {
    	if (str1 == null && str2 == null)
    		return  true;
    	if (str1 == null || str2 == null)
    		return false;
    	if (str1.trim().length() != str2.trim().length())
    		return false;
        if (str1.trim().equals(str2.trim()))
    	    return true;
    	Map<Character,Integer> map1 = new HashMap<Character,Integer>();
    	
    	char[] arr1 = str1.toCharArray();
    	char[] arr2 = str2.toCharArray();
    	int cnt = 0;
    	for (int i= 0; i< arr1.length; i++)
    	{
    	    cnt = map1.get(arr1[i]) != null ? map1.get(arr1[i])+1 : 1;
    	    map1.put(arr1[i], cnt);
    	}
    	int cnt1 =0;
    	for (int i= 0; i< arr2.length; i++)
    	{
    		if (map1.get(arr2[i]) != null)
    		{
    		    cnt1 = map1.get(arr2[i]);
    			if (cnt1 > 0)
    			    cnt1= cnt1 -1 ;
    		}
    	    map1.put(arr2[i], cnt1);
    	}
    	boolean retVal = false;
    	for (Map.Entry<Character,Integer> entry : map1.entrySet())
    	{
    		cnt = entry.getValue();
    		if (cnt > 0)
    		{
    			return false;
    		}
   		    else if (cnt == 0)
    			retVal = true;
       	}
    	return retVal;
    }
}
