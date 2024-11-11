package arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets 
{
	/**
	 * Algorithm: Start from empty subset from output list. On each step take new character from string and 
	 * generate new subset from existing ones.
	 * Eg.
	 * 
	 * str = "abc". 
	 * 
	 * Initial output list will contains empty string "". So, output = {""}
	 * Take first character "a",  create new subset by adding into each existing subset i.e "" .  So, output = {"","a"}
	 * Take second character "b", create new subset by adding into each existing subset i.e "" and "a". So, output = {"","a","b","ab"}
	 * Take second character "c", create new subset by adding into each existing subset i.e "" and "a". So, output = {"","a","b","ab","c","ac","bc","abc"}
	 * 
	 * Time complexity: O(N*2^N) , Space complexity O(N*2^N).
	 * @param str
	 */
	public static void subsetByCasceding(String str)
	{
		List <String> output = new ArrayList<String>();
		output.add("");
		for (int i=0 ; i<str.length(); i++)
		{
			List<String> newsubsets = new ArrayList<String>();
			for (String s:output)
			{
				newsubsets.add(s+str.charAt(i));
			}
			
			for (String s:newsubsets)
			{
				output.add(s);
			}
		}
		
		for (String s : output)
		{ 
			System.out.print("{");
		    System.out.print(s);
		    System.out.print("}");
		}
	}
	
	
	/**
	 * Given as string like abc, find all subsets of the given strings like a,b,c,ab,ac,bc,abc. 
	 * Idea: Total number of subet is equal to 2^(length of string). So, if we carefully see, it
	 * is total binary numbers from 0 to 2^n.
	 * E.g:
	 * 
	 * 000 - {}
	 * 001 - {a}
	 * 010 - {b}
	 * 011 - {b,c}
	 * 100 - {c}
	 * 101 - {a,c}
	 * 111 - {a,b,c)
	 */
	
	public static void subsetsByBinary(String str)
	{
		char [] set = str.toCharArray();
		int length = set.length;
		for (int i=0 ; i < (1<<length) ; i++)
		{
			System.out.print("{"); 
			for (int j=0 ; j < length ; j++)
			{
				/**
				 * (1<<j) is the number with jth bit as 1. E.g 1<<0 means 1st bit is 1, 1<<1 means 2nd bit is 1 and so on. 
				 *  So, when with do logical "AND" with i (binary number), it says if particular character is present in substring or not.   
				 */
				if ((i & (1<<j)) > 0)
				{
					System.out.print(""+set[j]);
				} 
			}
			System.out.print("}");
		}
	}
	
	private static void subsetByRecursionBackTracking(String str,int start, List<String> result, StringBuilder list)
	{
		result.add(list.toString());
		
		for (int i=start; i<str.length(); i++)
		{
			list.append(str.charAt(i));
			subsetByRecursionBackTracking(str,i+1,result,list);
			list.deleteCharAt(list.length()-1);
		}
	}
    /**
     * 
     * @param args
     */
	public static void main(String args[])
	{
		String str = "abc";
		System.out.println("Subset by cascading: ");
		subsetByCasceding(str);
		
		System.out.println("\nSubset by binary approach: ");
		subsetsByBinary(str);
		
		List<String> result = new ArrayList<>();
		subsetByRecursionBackTracking(str,0,result,new StringBuilder());
		
		System.out.println("\nSubset by recursion backtracking approach: ");
		
		for (String s : result)
		{
			System.out.print("{"+s+"} ");
		}
	}
}
