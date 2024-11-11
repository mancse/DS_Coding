package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetSum 
{
	  public static void subsetsum(int input[],int sum, int start,List<Integer> list, List<List<Integer>> result)
	  {
	     if (sum < 0)
		 return;
		 
		 if (start >= input.length)
		 return;
		 
		 if (start == input.length - 1 && sum == 0)
		 {
		    result.add(new ArrayList<>(list));
		    return;
		 }
		 
		 list.add(input[start]);
		 subsetsum(input,sum-input[start],start+1,list,result);
		 list.remove(list.size()-1);
		 subsetsum(input,sum,start+1,list,result);
	  }
	  
	  public static void subsetsumDP(int input[],int sum, int start,List<Integer> list, List<List<Integer>> result,Map<String,List<List<Integer>>> memo)
	  {
	     if (sum < 0)
		 return;
		 
	     if (memo.containsKey(start+"_"+sum))
	     {
	    	 List<List<Integer>> res = memo.get(start+"_"+sum);
	    	 for(List<Integer> r : res)
	    	 {
	    		 r.addAll(list);
	    	 }
	    	 return;
	     }
	     
		 if (start >= input.length)
		 return;
		 
		 if (start == input.length - 1 && sum == 0)
		 {
		    result.add(new ArrayList<>(list));
		    return;
		 }
		 
		 list.add(input[start]);
		 subsetsumDP(input,sum-input[start],start+1,list,result,memo);
		 list.remove(list.size()-1);
		 subsetsumDP(input,sum,start+1,list,result,memo);
		 
		 memo.put(start+"_"+sum, new ArrayList<>(result));
	  }
	  
	  public static void main(String args[])
      {
    	  int input [] = {1,2,3,4};
    	  List<List<Integer>> result = new ArrayList<>();
    	  subsetsum(input,4,0,new ArrayList<Integer>(),result);
    	  
    	  System.out.println("\nSubsets sum: ");
    	  for(List<Integer> res : result)
    	  {
    		  System.out.print("{");
    		  for (Integer r : res)
    		  {
    			  System.out.print(" "+r);
    		  }
    		  System.out.print("}");
    	  }
    	  
    	  Map<String,List<List<Integer>>> memo = new HashMap<>();
    	  subsetsumDP(input,4,0,new ArrayList<Integer>(),result,memo);
    	  
    	  System.out.println("\nSubsets sum using DP : ");
    	  for(List<Integer> res : result)
    	  {
    		  System.out.print("{");
    		  for (Integer r : res)
    		  {
    			  System.out.print(" "+r);
    		  }
    		  System.out.print("}");
    	  }
      }
}
