package arrays;

import java.util.Scanner;

public class RotateNumber {
	  public static void main(String[] args) {
		    Scanner scan = new Scanner(System.in);
		    int num = scan.nextInt();
		    int k = scan.nextInt();
		    int res = rotate(num,k);
		    System.out.println(res);
		    }
		    
		    private static int rotate(int num, int k){
		        
		        String nums = String.valueOf(num);
		        String str1 = null;
		        String str2 = null;
		        String str3 = null;
		        String str4 = null;
		        String str = null;
		        
		        if (k > 0)
		        {
		            int k1= k % nums.length();
		            str1 = nums.substring(0,nums.length() - k1);
		            str2 = nums.substring(nums.length() - k1, nums.length());
		           
		        }
		        else
		        {
		            int k1= Math.abs(k) % nums.length();
		            str1 = nums.substring(0,k1);
		            str2 = nums.substring(k1,nums.length());
		        }
		        
		         str3 = reverse(str1);
		         str4 = reverse(str2);
		         str = reverse(str3+str4);
		        return Integer.parseInt(str);
		    }
		    
		    private static String reverse(String input){
		        
		        char[] inputs = input.toCharArray();
		        int left = 0;
		        int right = inputs.length-1;
		        while(left <= right){
		            char tmp = inputs[right];
		            inputs[right] = inputs[left];
		            inputs[left] = tmp;
		            left++;
		            right--;
		        }
		        
		        return String.valueOf(inputs);
		    }
}
