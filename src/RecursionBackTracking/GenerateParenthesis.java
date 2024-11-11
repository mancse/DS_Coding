package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis 
{
	public static void main(String args[])
	{
		List<String> result = generateParenthesis(3);
		System.out.println(result);
	}
	public static List<String> generateParenthesis(int n) 
    {
        List<String> result = new ArrayList<String>();
        
        generateAllParenthesis(result,"",n,0,0);
        return result;
    }
    
    public static void generateAllParenthesis(List<String> result,String s, int n,int obc,int cbc)
    {
        if (s.length() == 2*n)
        {
            result.add(s);
            return;
        }
        if (obc < n)
            generateAllParenthesis(result,s+"(",n,obc+1,cbc);
        if (cbc < obc)
            generateAllParenthesis(result,s+")",n,obc,cbc+1);
    }
}
