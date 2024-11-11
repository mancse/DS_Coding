package String;
/**
 * Find the longest common prefix from list of given strings array.
 * 
 * E.g: String arr[] = {"manoj","manojk","manish","manjulam"}
 * Expected output: man
 * @author Manoj.K
 *
 */
public class LongestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
	        if (strs.length ==0)
	            return "";
	        
	        String firstStr = strs[0];
	        for (int i=0; i<firstStr.length(); i++){
	            char ch=firstStr.charAt(i);
	            for (int j=1 ;j<strs.length; j++){
	                if (i>=strs[j].length() || ch != strs[j].charAt(i))
	                    return strs[0].substring(0,i);
	            }
	        }
	        return strs[0];
	}
	 
	public static void main(String args[]){
		String[] strs = {"manoj","manojk","manish","manjulam"};
		String prefix = longestCommonPrefix(strs);
		System.out.println("Longest prefix: "+prefix);
	}
}
