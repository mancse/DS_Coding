package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams 
{
	public static List<List<String>> groupAnagrams(String[] strs) 
    {
        List<List<String>> result = new ArrayList<>();
        
        if (strs == null || strs.length == 0)
            return result;
       
        Map<String,List<String>> map = new HashMap<>();
        
        for (String str : strs)
        {
            int chars [] = new int[26];
            for (int i=0; i<str.length() ; i++)
            {
                chars[str.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(chars);
            System.out.println("key: "+key);
            if (map.containsKey(key))
            {
                map.get(key).add(str);
            }
            else
            {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key,list);
            }
        }
        
        for (Map.Entry<String,List<String>> entry : map.entrySet())
        {
            result.add(entry.getValue());
        }
        
        return result;
    }
	
	public static void main(String args[])
	{
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		//String[] strs = {"boo", "bob"};
		List<List<String>> result = groupAnagrams(strs);
		System.out.println(result);
	}
}
