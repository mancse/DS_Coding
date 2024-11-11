package String;

public class StringUtils 
{
    public static String reverseString(String str)
    {
    	char [] strArr = str.toCharArray();
    	char tmp;
    	int i =0,j = strArr.length -1;
    	while (i <= j)
    	{
    		tmp = strArr[i];
    		strArr[i]  = strArr[j];
    		strArr[j] = tmp;
    		i++;
    		j--;
    	}
    	return new String(strArr);
    }
    
    public static void main(String args[])
    {
    	String str = "Manoj Kumar";
    	System.out.println(" "+reverseString(str));
    }
}
