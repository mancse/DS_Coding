package String;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a string s containing only digits, return all possible valid IP addresses that can be 
 * obtained from s. You can return them in any order.

 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated
 * by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid 
 * IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 
 * 
 * Eg: 1
 * 
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * 
 * Eg: 2:
 * 
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * 
 * 
 * https://leetcode.com/problems/restore-ip-addresses/
 * @author Manoj.K
 *
 */
public class RestoreIPAddress {
public static List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<String>();
        for (int i=1; i<=3 && i < s.length(); i++){
            String first= s.substring(0,i);
            
            if (isValidIP(first)){
                for (int j=1; j<=3 && i+j < s.length(); j++){
                    String second = s.substring(i,i+j);
                    
                    if (isValidIP(second)){
                        for (int k=1; k<=3 && i+j+k < s.length(); k++){
                            String third = s.substring(i+j, i+j+k);
                            String fourth = s.substring(i+j+k);
                            
                            if (isValidIP(third) && isValidIP(fourth)){
                                StringBuilder sb = new StringBuilder();
                                sb.append(first).append(".").append(second).append(".").append(third).append(".").append(fourth);
                                result.add(sb.toString());
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private static boolean isValidIP(String s){
        if (s.length() >3)
            return false;
        if (s.length() > 1 && s.startsWith("0"))
            return false;
        int ip= Integer.parseInt(s);
        if (ip >=0 && ip <=255)
            return true;
        
        return false;
    }
}
